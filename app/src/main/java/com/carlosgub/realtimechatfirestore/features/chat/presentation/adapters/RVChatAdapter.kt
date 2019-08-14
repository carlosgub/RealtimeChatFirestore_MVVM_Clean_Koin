package com.carlosgub.realtimechatfirestore.features.chat.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlosgub.realtimechatfirestore.R
import com.carlosgub.realtimechatfirestore.features.chat.presentation.model.ChatVM
import kotlinx.android.synthetic.main.chat_item.view.*

class RVChatAdapter : RecyclerView.Adapter<RVChatAdapter.ViewHolder>() {


    val mLst: MutableList<ChatVM> = mutableListOf()
    private var mRecyclerView: RecyclerView? = null

    fun add(shoppingCartProductVM: ChatVM) {
        mLst.add(shoppingCartProductVM)
        notifyItemInserted(mLst.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.chat_item, parent, false
        )
    )

    override fun getItemCount() = mLst.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mLst[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(chatVM: ChatVM) {
            itemView.tvChatItemUsername.text = chatVM.username
            itemView.tvChatItemMessage.text = chatVM.message
        }
    }
}