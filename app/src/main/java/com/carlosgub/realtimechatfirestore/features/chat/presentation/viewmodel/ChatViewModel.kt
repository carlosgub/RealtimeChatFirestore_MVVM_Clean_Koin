package com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.carlosgub.realtimechatfirestore.core.interactor.Interactor
import com.carlosgub.realtimechatfirestore.core.platform.BaseViewModel
import com.carlosgub.realtimechatfirestore.features.chat.domain.interactor.AddMessageInteractor
import com.carlosgub.realtimechatfirestore.features.chat.domain.interactor.GetChatInteractor
import com.carlosgub.realtimechatfirestore.features.chat.domain.interactor.VerifyUsernameInteractor
import com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.viewstate.ChatVS
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ChatViewModel(private val verifyUsernameInteractor: VerifyUsernameInteractor,
                    private val getChatInteractor:GetChatInteractor,
                    private val addMessageInteractor: AddMessageInteractor
): BaseViewModel() {

    val state = MutableLiveData<ChatVS>()

    fun verifyUsername() {
        disposables.add(
            verifyUsernameInteractor.execute(
                Interactor.None
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    state.value = ChatVS.OnUsernameSavedSucess(it)
                }, {
                    Log.d(":)",it.message.toString())
                })
        )
    }

    fun getChat(){
        disposables.add(
            getChatInteractor.execute(
                Interactor.None
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    state.value = ChatVS.OnMessageReceived(it)
                },{
                    Log.d(":)",it.message.toString())
                },{
                    state.value = ChatVS.OnChatComplete
                })
        )
    }

    fun addMessage(message:String){
        disposables.add(
            addMessageInteractor.execute(
                AddMessageInteractor.Params(message)
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    state.value = ChatVS.OnMessageComplete
                },{
                    Log.d(":)",it.message.toString())
                })
        )
    }
}