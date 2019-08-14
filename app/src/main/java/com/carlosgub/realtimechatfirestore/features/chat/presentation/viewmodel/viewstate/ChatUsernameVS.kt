package com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.viewstate

sealed class ChatUsernameVS {
    object OnUsernameSavedSucess:
        ChatUsernameVS()
    //class ChatMessage(val keypadAddProductsVM: KeypadAddProductsVM) : ChatUsernameVS()
    object AddProductsSuccess : ChatUsernameVS()
}