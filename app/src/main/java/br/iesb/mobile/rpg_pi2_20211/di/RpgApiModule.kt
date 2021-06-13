package br.iesb.mobile.rpg_pi2_20211.di

import br.iesb.mobile.rpg_pi2_20211.domain.Email
import br.iesb.mobile.rpg_pi2_20211.domain.Jogador
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

@Module
@InstallIn(SingletonComponent::class)
class RpgApiModule {

    @Provides
    fun provideRetrofit(): Retrofit {

        var gson = GsonBuilder()
            .setLenient()
            .create()

            return Retrofit.Builder()
            .baseUrl("https://c5b9bda085ba.ngrok.io/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        //https://teste-api-poo-rpg.herokuapp.com/
    }

    @Provides
    fun prividesRPGService(retrofit:Retrofit): RpgApiService{
            return retrofit.create(RpgApiService::class.java)
    }
}


interface RpgApiService {
    @GET("jogadores/user/{email}")
    @Headers("Content-Type: application/json")
    suspend fun getID(@Path("email") email: String?): Int

    @Headers("Content-Type: application/json")
    @POST("jogador/criarjogador")
    suspend fun addplayer(@Body body: Jogador) : Int

    @Headers("Content-Type: application/json")
    @POST("/loja/{idURL}/{opcao}")
    suspend fun taverna(@Query("idURL") idURL: Int, @Query("opcao") opcao: String): String

    @Headers("Content-Type: application/json")
    @GET("batalha/{n}/{idURL}/{op}")
    fun batalha(@Path("n") n: Int, @Path("idURL") id: Int, @Path("op") op:Int): Call<String>




}