package br.iesb.mobile.rpg_pi2_20211.di

import br.iesb.mobile.rpg_pi2_20211.domain.Jogador
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

@Module
@InstallIn(SingletonComponent::class)
class RpgApiModule {

    @Provides
    fun provideRetrofit(): Retrofit {

        var gson = GsonBuilder()
            .setLenient()
            .create()

            return Retrofit.Builder()
            .baseUrl("https://teste-api-poo-rpg.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun prividesRPGService(retrofit:Retrofit): RpgApiService{
            return retrofit.create(RpgApiService::class.java)
    }
}


interface RpgApiService {
    @GET("jogadores")
    @Headers("Content-Type: application/json")
    suspend fun searchCharacter(): Response<List<Jogador>>

    @Headers("Content-Type: application/json")
    @POST("jogadores/criarjogador")
    suspend fun addplayer(@Body body: Jogador)

}