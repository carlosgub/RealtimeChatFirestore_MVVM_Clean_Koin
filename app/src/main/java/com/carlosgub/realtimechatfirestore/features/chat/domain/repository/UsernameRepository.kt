package com.carlosgub.realtimechatfirestore.features.chat.domain.repository

import com.carlosgub.realtimechatfirestore.features.chat.domain.model.UsernameEntity
import io.reactivex.Completable
import io.reactivex.Single

interface UsernameRepository {
    fun setUsername(username: String): Completable
    fun verifyUsername(): Single<Boolean>
    fun getUsername(): Single<UsernameEntity>
}