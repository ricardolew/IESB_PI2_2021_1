package br.iesb.mobile.rpg_pi2_20211.ui.fragment.chatbot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentCadastroBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentChatBotBinding
import br.iesb.mobile.rpg_pi2_20211.domain.Chat
import br.iesb.mobile.rpg_pi2_20211.domain.ResultChat
import br.iesb.mobile.rpg_pi2_20211.viewmodel.ChatViewModel
import br.iesb.mobile.rpg_pi2_20211.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class ChatBotFragment : Fragment() {

    private lateinit var binding: FragmentChatBotBinding
    private val Viewmodel: ChatViewModel by viewModels()

    val sessionId= UUID.randomUUID().toString()
    var mensagem = MutableLiveData<String?>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBotBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragment=this
        binding.viewmodel = Viewmodel

        setupListeners()
        setupRecyclerView()

        return binding.root
    }


    private fun setupRecyclerView() {
        binding.rvMessages.adapter = MessagingAdapter(mutableListOf())
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.stackFromEnd = true
        layoutManager.isSmoothScrollbarEnabled = true
        layoutManager.reverseLayout = false
        binding.rvMessages.layoutManager = layoutManager
    }

    private fun setupListeners() {
        Viewmodel.message.observe(viewLifecycleOwner) {
            if (it != null)
                it.forEach {  i->
                    val chatmessage = Chat(i.message)
                    AddRecyclerView(chatmessage)

                }

        }
    }

    private fun AddRecyclerView(message: Chat) {
        val adapter = binding.rvMessages.adapter as MessagingAdapter
        val messagesList = adapter.messages
        messagesList.add(message)
        adapter.notifyDataSetChanged()
        binding.rvMessages.scrollToPosition(messagesList.size - 1)
    }

    @SuppressWarnings
    fun Send() {
        val message = mensagem.value
        if (!message.isNullOrBlank()) {
            val chatbotMessage = Chat(message, sessionId, true)
            val response = Viewmodel.createmessage(message,sessionId,true)
            AddRecyclerView(chatbotMessage)
            mensagem.value = null
        }


    }


}


