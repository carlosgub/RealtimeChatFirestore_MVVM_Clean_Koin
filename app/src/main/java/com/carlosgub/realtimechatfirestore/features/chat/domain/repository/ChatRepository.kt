package com.carlosgub.realtimechatfirestore.features.chat.domain.repository

import com.carlosgub.realtimechatfirestore.features.chat.domain.model.ChatEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface ChatRepository {
    fun getChat(): Observable<ChatEntity>
    fun addMessage(username: String, message: String): Completable
}