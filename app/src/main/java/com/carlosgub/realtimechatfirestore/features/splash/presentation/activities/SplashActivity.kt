package com.carlosgub.realtimechatfirestore.features.splash.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.carlosgub.realtimechatfirestore.R
import com.carlosgub.realtimechatfirestore.core.platform.BaseActivity
import com.carlosgub.realtimechatfirestore.features.chat.presentation.activities.ChatActivity

class SplashActivity : BaseActivity() {

    override fun layout(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this,ChatActivity::class.java))
            finish()
        }, 1500)
    }

    override fun getViewModelComplete() {}
}
