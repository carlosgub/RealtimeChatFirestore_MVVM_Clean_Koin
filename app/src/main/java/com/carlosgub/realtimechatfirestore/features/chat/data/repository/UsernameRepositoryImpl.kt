package com.carlosgub.realtimechatfirestore.features.chat.data.repository

import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.preference.UsernameSharedPreference
import com.carlosgub.realtimechatfirestore.features.chat.data.mapper.UsernameDataMapper
import com.carlosgub.realtimechatfirestore.features.chat.domain.model.UsernameEntity
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.UsernameRepository
import io.reactivex.Completable
import io.reactivex.Single

class UsernameRepositoryImpl(private val usernameSharedPreference: UsernameSharedPreference) :UsernameRepository{

    private val mUsernameDataMapper by lazy { UsernameDataMapper() }

    override fun setUsername(username: String): Completable {
        return usernameSharedPreference.setUsername(username)
    }

    override fun verifyUsername(): Single<Boolean> {
        return usernameSharedPreference.verifyUsername()
    }

    override fun getUsername(): Single<UsernameEntity> {
        return usernameSharedPreference.getUsername().map(mUsernameDataMapper::map)
    }
}