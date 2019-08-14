package com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.viewstate

import com.carlosgub.realtimechatfirestore.features.chat.presentation.model.ChatVM

sealed class ChatVS {
    class OnUsernameSavedSucess(val exist: Boolean) : ChatVS()
    class OnMessageReceived(val chatVM: ChatVM) : ChatVS()
    object OnChatComplete : ChatVS()
    object OnMessageComplete : ChatVS()
    //class ChatMessage(val keypadAddProductsVM: KeypadAddProductsVM) : ChatUsernameVS()
}