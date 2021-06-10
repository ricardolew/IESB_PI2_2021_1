package br.iesb.mobile.rpg_pi2_20211.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.iesb.mobile.rpg_pi2_20211.domain.Chat
import br.iesb.mobile.rpg_pi2_20211.domain.ResultChat
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class ChatRepository @Inject constructor(
//    private val retrofit: Retrofit,

) {

    suspend fun createmessage(text: String, sessionId: String, cliente: Boolean) : List<ResultChat>?{
        val client = OkHttpClient.Builder()
            .connectTimeout(6000, TimeUnit.SECONDS)
            .readTimeout(6000, TimeUnit.SECONDS).build()

        var gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dialogflow-android.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val request = retrofit.create(ChatService::class.java)


        println( "Repo create")
        val chatbotmessage = Chat(text,sessionId,cliente)

        Log.d("RESPONSE","antes request")

        val response =  request.createmessage(chatbotmessage)


        val MensagemBot = MutableLiveData<List<ResultChat>>()



//        response.forEach { r ->
//            MensagemBot = r.message
//        }

        Log.d("RESPONSE","depois request")

        Log.d("RESPONSE","${response}")

        return response


    }
}

interface ChatService {
    @Headers("Content-Type: application/json")
    @POST("api/message/text/send")
    suspend fun createmessage(@Body body: Chat): List<ResultChat>
}