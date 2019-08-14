package com.carlosgub.realtimechatfirestore.core.preference

import android.content.Context
import android.content.SharedPreferences

class Preference(val context: Context) {

    private val PREF_NAME = "Realtime-chat"

    fun initSharedPreference():SharedPreferences{
        return context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    }
}