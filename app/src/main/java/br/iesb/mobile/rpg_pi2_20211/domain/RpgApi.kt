package br.iesb.mobile.rpg_pi2_20211.domain

data class Jogador(
    val classe: Int,
    val nome: String?,
    val elemento: Int
)

data class CharacterApiResult(
    val results: List<Jogador>
)

data class ResultCreate(
    val text: String?
)


