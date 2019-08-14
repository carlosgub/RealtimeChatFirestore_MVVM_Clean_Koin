package com.carlosgub.realtimechatfirestore.features.chat.data.mapper

import com.carlosgub.realtimechatfirestore.core.mapper.Mapper
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase.model.ChatF
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.preference.model.UsernameP
import com.carlosgub.realtimechatfirestore.features.chat.domain.model.ChatEntity
import com.carlosgub.realtimechatfirestore.features.chat.domain.model.UsernameEntity

class UsernameDataMapper : Mapper<UsernameP, UsernameEntity> {
    override fun map(origin: UsernameP) = UsernameEntity(
        username = origin.username
    )
}