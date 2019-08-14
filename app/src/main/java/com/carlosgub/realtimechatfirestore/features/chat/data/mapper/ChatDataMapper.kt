package com.carlosgub.realtimechatfirestore.features.chat.data.mapper

import com.carlosgub.realtimechatfirestore.core.mapper.Mapper
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase.model.ChatF
import com.carlosgub.realtimechatfirestore.features.chat.domain.model.ChatEntity

class ChatDataMapper : Mapper<ChatF, ChatEntity> {
    override fun map(origin: ChatF) = ChatEntity(
        username = origin.username,
        message = origin.message
    )
}