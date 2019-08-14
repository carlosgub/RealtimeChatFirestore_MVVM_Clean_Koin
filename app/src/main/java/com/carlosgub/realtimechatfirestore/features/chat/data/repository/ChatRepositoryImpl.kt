package com.carlosgub.realtimechatfirestore.features.chat.data.repository

import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase.FirestoreFirebase
import com.carlosgub.realtimechatfirestore.features.chat.data.mapper.ChatDataMapper
import com.carlosgub.realtimechatfirestore.features.chat.domain.model.ChatEntity
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.ChatRepository
import io.reactivex.Completable
import io.reactivex.Observable

class ChatRepositoryImpl(private val firestoreFirebase: FirestoreFirebase) : ChatRepository {

    private val mChatDataMapper by lazy { ChatDataMapper() }

    override fun getChat(): Observable<ChatEntity> {
        return firestoreFirebase.getChat().map(mChatDataMapper::map)
    }

    override fun addMessage(username: String, message: String): Completable {
        return firestoreFirebase.addMessage(username, message)
    }
}