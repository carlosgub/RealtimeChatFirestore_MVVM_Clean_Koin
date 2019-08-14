package com.carlosgub.realtimechatfirestore.features.chat.presentation.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlosgub.realtimechatfirestore.R
import com.carlosgub.realtimechatfirestore.core.platform.BaseActivity
import com.carlosgub.realtimechatfirestore.features.chat.presentation.adapters.RVChatAdapter
import com.carlosgub.realtimechatfirestore.features.chat.presentation.dialogfragment.ChatUsernameDialogFragment
import com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.ChatViewModel
import com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.viewstate.ChatVS
import kotlinx.android.synthetic.main.activity_chat.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatActivity : BaseActivity() {

    private val viewModel: ChatViewModel by viewModel()
    private val chatAdapter = RVChatAdapter()

    override fun layout(): Int = R.layout.activity_chat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModelComplete()
        initRV()
        viewModel.verifyUsername()
        viewModel.getChat()

        ibChatSent.setOnClickListener {
            val message = etChatMessage.text.toString()
            if(message.isNotEmpty()){
                viewModel.addMessage(message)
                etChatMessage.text.clear()
            }
        }
    }

    private fun initRV(){
        rvChat.apply {
            layoutManager = LinearLayoutManager(this@ChatActivity)
            adapter = chatAdapter
        }
    }

    override fun getViewModelComplete() {
        viewModel.state.observe(this, Observer {
            when (it) {
                is ChatVS.OnUsernameSavedSucess -> {
                    if(!it.exist){
                        ChatUsernameDialogFragment().show(supportFragmentManager, ChatUsernameDialogFragment::class.java.name)
                    }
                }
                is ChatVS.OnMessageReceived -> {
                    chatAdapter.add(it.chatVM)
                    rvChat.smoothScrollToPosition(chatAdapter.itemCount-1)
                }
                is ChatVS.OnChatComplete -> {

                }
            }
        })
    }
}
