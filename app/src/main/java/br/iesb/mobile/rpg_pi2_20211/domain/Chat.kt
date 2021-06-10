package br.iesb.mobile.rpg_pi2_20211.domain

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

data class Chat (
    var message: String?,
    val sessionId: String? = null,
    val cliente: Boolean? = false
    )



data class ResultChat(
    val message: String?
)



