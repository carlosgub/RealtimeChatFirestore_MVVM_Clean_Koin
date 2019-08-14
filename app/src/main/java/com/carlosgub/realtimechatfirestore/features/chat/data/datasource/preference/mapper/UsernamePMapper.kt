package com.carlosgub.realtimechatfirestore.features.chat.data.datasource.preference.mapper

import com.carlosgub.realtimechatfirestore.core.mapper.Mapper
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase.model.ChatF
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.preference.model.UsernameP

class UsernamePMapper : Mapper<String, UsernameP> {
    override fun map(origin:String) = UsernameP(
        username = origin
    )
}