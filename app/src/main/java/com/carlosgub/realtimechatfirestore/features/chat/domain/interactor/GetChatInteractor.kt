package com.carlosgub.realtimechatfirestore.features.chat.domain.interactor

import com.carlosgub.realtimechatfirestore.core.interactor.Interactor
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.ChatRepository
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.UsernameRepository
import com.carlosgub.realtimechatfirestore.features.chat.presentation.model.ChatVM
import com.carlosgub.realtimechatfirestore.features.chat.presentation.model.mapper.ChatVMMapper
import io.reactivex.Completable
import io.reactivex.Observable

class GetChatInteractor(private val chatRepository: ChatRepository):
    Interactor<Interactor.None, Observable<ChatVM>> {

    private val mChatVMMapper by lazy { ChatVMMapper() }

    override fun execute(params: Interactor.None): Observable<ChatVM> {
        return chatRepository.getChat().map(mChatVMMapper::map)
    }
}