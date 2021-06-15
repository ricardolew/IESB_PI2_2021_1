package br.iesb.mobile.rpg_pi2_20211.domain

data class Jogador(
    val classe: Int?,
    val nome: String?,
    val elemento: Int,
    val email: String?
)

data class Getnome(
    val nome: String?
)

data class Personagem(
    val ataque: Int,
    val defesa: Int,
    val batalhas: Int,
    val bonusEfetivo: Int,
    val dinheiro: Int,
    val elemento: Int,
    val id: Int = -1,
    val masAtaque: Int,
    val maxDefesa: Int,
    val maxMana: Int,
    val maxVelocidade: Int,
    val maxVida: Int,
    val nivel: Int,
    val nome: String,
    val pontosMana: Int,
    val pontosSabedoria: Float,
    val pontosVida: Int,
    val stab: Int,
    val statusBaseAtaque: Int,
    val statusBaseMana: Int,
    val statusBaseVelocidade: Int,
    val valBaseVida: Int,
    val userEmail: String,
    val velocidade: Int,
    val xp: Int
    )

data class BatalhaDTO(
    var mensagemInicio: String?,
    var mensagem: String?,
    var mensagemFugir: String?,
    var mensagemTurnoJogador: String?,
    var mensagemTurnoMonstro: String?,
    var mensagemMonstro: String?,
    var mensagemAtaque: String?,
    var mensagemMana: String?,
    var mensagemDerrota: String?,
    var mensagemVitoria: String?,
    var mensagemFim: String?
)




