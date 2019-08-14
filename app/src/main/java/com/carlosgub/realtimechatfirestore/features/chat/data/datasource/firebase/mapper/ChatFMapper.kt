package com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase.mapper

import com.carlosgub.realtimechatfirestore.core.mapper.Mapper
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase.model.ChatF
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.preference.model.UsernameP

class ChatFMapper : Mapper<Map<String, Any>, ChatF> {
    override fun map(origin: Map<String, Any>) = ChatF(
        username = origin["username"].toString(),
        message = origin["message"].toString()
    )
}