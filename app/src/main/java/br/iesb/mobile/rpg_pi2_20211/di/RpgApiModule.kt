package br.iesb.mobile.rpg_pi2_20211.di

import br.iesb.mobile.rpg_pi2_20211.domain.*
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
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

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        var okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

            return Retrofit.Builder()
            .baseUrl("https://1a9fc1d5ba7a.ngrok.io/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
            .build()

        //https://teste-api-poo-rpg.herokuapp.com/
    }

    @Provides
    fun prividesRPGService(retrofit:Retrofit): RpgApiService{
            return retrofit.create(RpgApiService::class.java)
    }
}


interface RpgApiService {

//    @GET("jogadores/user/{email}")
//    @Headers("Content-Type: application/json")
//    suspend fun getID(@Path("email") email: String?): Int
//
//    @GET("jogadores/user/nome/{email}")
//    @Headers("Content-Type: application/json")
//    suspend fun getNome(@Path("email") email: String?): String
//
//    @GET("jogadores/user/xp/{email}")
//    @Headers("Content-Type: application/json")
//    suspend fun getNivel(@Path("email") email: String?): String

    @GET("jogadores/{email}")
    @Headers("Content-Type: application/json")
    suspend fun getPersonagem(@Path("email") email: String?): Personagem

    @Headers("Content-Type: application/json")
    @POST("jogador/criarjogador")
    suspend fun addplayer(@Body body: Jogador) : String

    @Headers("Content-Type: application/json")
    @GET("loja/{idURL}/{opcao}")
    suspend fun taverna(@Path("idURL") idURL: String, @Path("opcao") opcao: String): Int

    @Headers("Content-Type: application/json")
    @GET("batalha/{n}/{idURL}/{op}")
    suspend fun batalha(@Path("n") n: Int, @Path("idURL") id: String, @Path("op") op:Int): BatalhaDTO

    @Headers("Content-Type: application/json")
    @GET("elemento/{idURL}/{elm}")
    suspend fun trocaelemento( @Path("idURL") idURL: String, @Path("elm") elm:Int)

    @GET("jogador/deletar/{email}")
    @Headers("Content-Type: application/json")
    suspend fun deletar(@Path("email") email: String?)

}