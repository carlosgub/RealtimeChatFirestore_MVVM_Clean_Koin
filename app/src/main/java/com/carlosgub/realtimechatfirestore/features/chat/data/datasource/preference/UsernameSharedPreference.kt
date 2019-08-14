package com.carlosgub.realtimechatfirestore.features.chat.data.datasource.preference

import androidx.core.content.edit
import com.carlosgub.realtimechatfirestore.core.preference.Preference
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.preference.mapper.UsernamePMapper
import com.carlosgub.realtimechatfirestore.features.chat.data.datasource.preference.model.UsernameP
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.Exception

class UsernameSharedPreference (private val sharedPreferences: Preference){

    companion object{
        val SP_NAME = "NAME"
    }

    private val mUsernamePMapper by lazy { UsernamePMapper() }

    fun setUsername(name:String) :Completable{
        return Completable.create {
            try{
                sharedPreferences.initSharedPreference().edit {
                    putString(SP_NAME,name)
                }.apply {

                }
                it.onComplete()
            }catch (ex:Exception){
                it.onError(ex)
            }
        }
    }

    fun verifyUsername(): Single<Boolean> {
        return Single.create {
            try{
                if(sharedPreferences.initSharedPreference().getString(SP_NAME,null)!=null){
                    it.onSuccess(true)
                }else{
                    it.onSuccess(false)
                }
            }catch (ex:Exception){
                it.onError(ex)
            }
        }
    }

    fun getUsername():Single<UsernameP> {
        return Single.create {
            try {
                if(sharedPreferences.initSharedPreference().getString(SP_NAME,null)!=null){
                    it.onSuccess(mUsernamePMapper.map(sharedPreferences.initSharedPreference().getString(SP_NAME,null)!!))
                }else{
                    it.onError(Throwable("No esta seteado el username"))
                }
            }catch (ex:Exception){
                it.onError(ex)
            }
        }
    }
}