package br.iesb.mobile.rpg_pi2_20211.repository

import androidx.lifecycle.MutableLiveData
import br.iesb.mobile.rpg_pi2_20211.domain.Jogador
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import javax.inject.Inject




class RpgApiRepository @Inject constructor() {


    val retrofit = Retrofit.Builder()
        .baseUrl("https://teste-api-poo-rpg.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val request = retrofit.create(EndpointsRpgApi::class.java)

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

interface EndpointsRpgApi {
    @GET("jogadores")
    @Headers("Content-Type: application/json")
    suspend fun searchCharacter(): Response<List<Jogador>>

    @Headers("Content-Type: application/json")
    @POST("jogadores/criarjogador")
    suspend fun addplayer(@Body body: Jogador): Call<Jogador>

}
