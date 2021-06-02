package br.iesb.mobile.rpg_pi2_20211.repository

import br.iesb.mobile.rpg_pi2_20211.di.RpgApiService
import br.iesb.mobile.rpg_pi2_20211.domain.Jogador
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class RpgApiRepository @Inject constructor(
//    private val retrofit: Retrofit,
    private val request: RpgApiService
) {


    suspend fun loadData() : Response<List<Jogador>> {
        val response = request.searchCharacter()
        return response
    }

    suspend fun createuser (classe:Int, Nome: String?, Elemento: Int){
        println( "Repo create")

        val NewPlayer = Jogador(classe,Nome,Elemento)
        println(NewPlayer.nome)
        request.addplayer(NewPlayer)


    }
}

