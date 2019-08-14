package com.carlosgub.realtimechatfirestore

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.carlosgub.realtimechatfirestore.di.modules
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class RealtimeChatFirestoreApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)

        startKoin {
            androidContext(this@RealtimeChatFirestoreApplication)
            androidLogger()
            modules(modules = modules)
        }

    }
}