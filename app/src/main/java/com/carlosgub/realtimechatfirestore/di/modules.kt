package com.carlosgub.realtimechatfirestore.di

import com.carlosgub.realtimechatfirestore.core.preference.Preference
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.firebase.FirestoreFirebase
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.preference.UsernameSharedPreference
import com.carlosgub.realtimechatfirestore.features.chat.data.repository.ChatRepositoryImpl
import com.carlosgub.realtimechatfirestore.features.chat.data.repository.UsernameRepositoryImpl
import com.carlosgub.realtimechatfirestore.features.chat.domain.interactor.AddMessageInteractor
import com.carlosgub.realtimechatfirestore.features.chat.domain.interactor.GetChatInteractor
import com.carlosgub.realtimechatfirestore.features.chat.domain.interactor.SetUsernameInteractor
import com.carlosgub.realtimechatfirestore.features.chat.domain.interactor.VerifyUsernameInteractor
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.ChatRepository
import com.carlosgub.realtimechatfirestore.features.chat.domain.repository.UsernameRepository
import com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.ChatUsernameViewModel
import com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.ChatViewModel
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val appModule = module {
    single {
        Preference(get())
    }
    factory { FirebaseFirestore.getInstance() }
}

private val chatModule = module {
    single{
        UsernameSharedPreference(get())
    }

    single{
        FirestoreFirebase(get())
    }

    single<UsernameRepository>{
        UsernameRepositoryImpl(get())
    }

    single<ChatRepository>{
        ChatRepositoryImpl(get())
    }

    single{SetUsernameInteractor(get())}
    single{VerifyUsernameInteractor(get())}
    single{GetChatInteractor(get())}
    single{AddMessageInteractor(get(),get())}

    viewModel { ChatUsernameViewModel(get()) }
    viewModel { ChatViewModel(get(),get(),get()) }
}

val modules = listOf(appModule, chatModule)