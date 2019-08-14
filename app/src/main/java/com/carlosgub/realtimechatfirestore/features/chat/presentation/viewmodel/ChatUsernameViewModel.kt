package com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.carlosgub.realtimechatfirestore.core.platform.BaseViewModel
import com.carlosgub.realtimechatfirestore.features.chat.domain.interactor.SetUsernameInteractor
import com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.viewstate.ChatUsernameVS
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ChatUsernameViewModel(private val setUsernameInteractor: SetUsernameInteractor): BaseViewModel() {

    val state = MutableLiveData<ChatUsernameVS>()

    fun setUsername(username:String) {
        disposables.add(
            setUsernameInteractor.execute(
                SetUsernameInteractor.Params(
                    username = username
                )
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    state.value = ChatUsernameVS.OnUsernameSavedSucess
                }, {
                    Log.d(":)",it.message.toString())
                })
        )
    }
}