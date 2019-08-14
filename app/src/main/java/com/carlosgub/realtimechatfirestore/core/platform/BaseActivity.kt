package com.carlosgub.realtimechatfirestore.core.platform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun layout(): Int

    abstract fun getViewModelComplete()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
    }
}