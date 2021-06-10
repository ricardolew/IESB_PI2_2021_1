package br.iesb.mobile.rpg_pi2_20211.interactor

import br.iesb.mobile.rpg_pi2_20211.domain.ResultChat
import br.iesb.mobile.rpg_pi2_20211.repository.ChatRepository
import javax.inject.Inject

class ChatInteractor @Inject constructor(
    private val repo: ChatRepository
) {

    suspend fun createmessage (text: String, sessionId: String, cliente: Boolean): List<ResultChat>? {
        println("it mensagem")
        return repo.createmessage(text, sessionId, cliente)

    }

}