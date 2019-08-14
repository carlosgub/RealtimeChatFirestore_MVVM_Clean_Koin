package com.carlosgub.realtimechatfirestore.features.chat.domain.interactor

import com.carlosgub.realtimechatfirestore.core.interactor.Interactor
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.UsernameRepository
import io.reactivex.Single

class VerifyUsernameInteractor(private val usernameRepository: UsernameRepository):
    Interactor<Interactor.None, Single<Boolean>> {

    override fun execute(params: Interactor.None): Single<Boolean> {
        return usernameRepository.verifyUsername()
    }
}