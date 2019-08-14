package com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase

import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase.mapper.ChatFMapper
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase.model.ChatF
import com.google.firebase.firestore.*
import io.reactivex.Completable
import io.reactivex.Observable
import java.util.*

class FirestoreFirebase (val db: FirebaseFirestore){

    companion object{
        val F_CHAT = "chat"
    }

    private val mChatFMapper by lazy { ChatFMapper() }

    fun getChat() : Observable<ChatF> {
        return Observable.create {
            try{
                val chatRef = db.collection(F_CHAT).orderBy("timestamp")
                /*chatRef.get().addOnCompleteListener {task->
                    if(task.isSuccessful){
                        task.result?.forEach {queryDocumentSnapshot: QueryDocumentSnapshot? ->
                            queryDocumentSnapshot?.let{query->
                                it.onNext(mChatFMapper.map(query.data))
                            }
                        }
                        it.onComplete()
                    }else{
                        it.onError(Throwable("Hubo un error"))
                    }
                }*/

                chatRef.addSnapshotListener { snapshots, e ->
                    for (dc in snapshots!!.documentChanges) {
                        when (dc.type) {
                            DocumentChange.Type.ADDED -> {
                                it.onNext(mChatFMapper.map(dc.document.data))
                            }
                            DocumentChange.Type.MODIFIED ->{ //Se llamaria si se modificaria un documento

                            }
                            DocumentChange.Type.REMOVED ->{ //Se llamaria si se eliminaria un documento

                            }
                        }
                    }
                }
            }catch (ex:Exception){
                it.onError(ex)
            }
        }
    }

    fun addMessage(username:String, message:String):Completable{
        return Completable.create {
            val data = hashMapOf(
                "username" to username,
                "message" to message,
                "timestamp" to Date().time
            )
            val chatRef = db.collection(F_CHAT)
            chatRef.add(data)
        }
    }
}