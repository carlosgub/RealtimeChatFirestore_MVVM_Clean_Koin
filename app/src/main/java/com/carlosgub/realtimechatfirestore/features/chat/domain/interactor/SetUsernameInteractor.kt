package com.carlosgub.realtimechatfirestore.features.chat.domain.interactor

import com.carlosgub.realtimechatfirestore.core.interactor.Interactor
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.UsernameRepository
import io.reactivex.Completable

class SetUsernameInteractor(private val usernameRepository: UsernameRepository):
    Interactor<SetUsernameInteractor.Params, Completable> {

    override fun execute(params: Params): Completable {
        return usernameRepository.setUsername(
            username = params.username
        )
    }

    data class Params(
        val username:String
    )
}