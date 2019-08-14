package com.carlosgub.realtimechatfirestore.features.chat.presentation.model.mapper

import com.carlosgub.realtimechatfirestore.core.mapper.Mapper
import com.carlosgub.realtimechatfirestore.features.chat.domain.model.ChatEntity
import com.carlosgub.realtimechatfirestore.features.chat.presentation.model.ChatVM

class ChatVMMapper : Mapper<ChatEntity, ChatVM> {
    override fun map(origin: ChatEntity) = ChatVM(
        username = origin.username,
        message = origin.message
    )
}