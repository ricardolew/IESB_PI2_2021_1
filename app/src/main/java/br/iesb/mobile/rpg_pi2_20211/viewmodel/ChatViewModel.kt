package br.iesb.mobile.rpg_pi2_20211.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.iesb.mobile.rpg_pi2_20211.domain.Chat
import br.iesb.mobile.rpg_pi2_20211.domain.ResultChat
import br.iesb.mobile.rpg_pi2_20211.interactor.ChatInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val app: Application,
    private val interactor: ChatInteractor,
) : AndroidViewModel(app) {

    var message = MutableLiveData<List<ResultChat>?>()

    //    var message : Response<List<Chat?>> = TODO("colocar")
    var Received = MutableLiveData<Chat>()

    fun createmessage(text: String, sessionId: String, cliente: Boolean) {
//        var chatmessage = Chat(text, sessionId, cliente)
        viewModelScope.launch {
          val resposta =  interactor.createmessage(text, sessionId, cliente)
            message.value = resposta

        }

    }
}
