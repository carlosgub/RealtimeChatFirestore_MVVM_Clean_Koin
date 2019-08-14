package com.carlosgub.realtimechatfirestore.features.chat.domain.interactor

import com.carlosgub.realtimechatfirestore.core.interactor.Interactor
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.ChatRepository
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.UsernameRepository
import com.carlosgub.realtimechatfirestore.features.chat.presentation.model.ChatVM
import com.carlosgub.realtimechatfirestore.features.chat.presentation.model.mapper.ChatVMMapper
import io.reactivex.Completable
import io.reactivex.Observable

class AddMessageInteractor(private val chatRepository: ChatRepository,
                           private val usernameRepository: UsernameRepository):
    Interactor<AddMessageInteractor.Params, Completable> {


    override fun execute(params: Params): Completable {
        return usernameRepository.getUsername().flatMapCompletable {
            chatRepository.addMessage(it.username,params.message)
        }
    }

    data class Params(
        val message:String
    )
}