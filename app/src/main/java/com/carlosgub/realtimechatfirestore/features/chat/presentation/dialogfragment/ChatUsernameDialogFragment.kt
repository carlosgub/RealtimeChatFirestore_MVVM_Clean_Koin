package com.carlosgub.realtimechatfirestore.features.chat.presentation.dialogfragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.carlosgub.realtimechatfirestore.R
import com.carlosgub.realtimechatfirestore.core.platform.BaseDialogFragment
import com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.ChatUsernameViewModel
import com.carlosgub.realtimechatfirestore.features.chat.presentation.viewmodel.viewstate.ChatUsernameVS
import kotlinx.android.synthetic.main.chat_username_dialogfragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatUsernameDialogFragment : BaseDialogFragment() {

    private val viewModel: ChatUsernameViewModel by viewModel()

    override fun layout() = R.layout.chat_username_dialogfragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewModelComplete()

        btChatUsernameDialogFragmentNeutral.setOnClickListener {
            if (tilChatUsernameDialogFragmentUsarname.editText?.text.toString().isNotEmpty()) {
                viewModel.setUsername(tilChatUsernameDialogFragmentUsarname.editText?.text.toString())
            }else{
                Toast.makeText(requireContext(),"Ingrese su username",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getViewModelComplete() {
        viewModel.state.observe(this@ChatUsernameDialogFragment, Observer {
            when (it) {
                is ChatUsernameVS.OnUsernameSavedSucess -> {
                    dismissAllowingStateLoss()
                }
            }
        })
    }
}