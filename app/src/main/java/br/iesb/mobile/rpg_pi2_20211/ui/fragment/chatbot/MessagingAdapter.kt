package br.iesb.mobile.rpg_pi2_20211.ui.fragment.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.ItemMensagemBinding
import br.iesb.mobile.rpg_pi2_20211.domain.Chat


class MessagingAdapter(
    var messages: MutableList<Chat>
): RecyclerView.Adapter<MessagingAdapter.PageHolder>() {



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessagingAdapter.PageHolder {
        return PageHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_mensagem, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MessagingAdapter.PageHolder, position: Int) {
        holder.binding.mensagem= messages[position]


    }

    override fun getItemCount() = messages.size

    inner class PageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemMensagemBinding = ItemMensagemBinding.bind(view)
    }


}
