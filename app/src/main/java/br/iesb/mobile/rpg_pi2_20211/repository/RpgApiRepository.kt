package br.iesb.mobile.rpg_pi2_20211.repository

import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import br.iesb.mobile.rpg_pi2_20211.di.RpgApiService
import br.iesb.mobile.rpg_pi2_20211.domain.Email
import br.iesb.mobile.rpg_pi2_20211.domain.Jogador
import br.iesb.mobile.rpg_pi2_20211.domain.ResultCreate
import br.iesb.mobile.rpg_pi2_20211.viewmodel.LoginViewModel
import br.iesb.mobile.rpg_pi2_20211.viewmodel.RpgApiViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class RpgApiRepository @Inject constructor(
//    private val retrofit: Retrofit,

    private val request: RpgApiService,
    private var auth: FirebaseAuth

) {

    var id: String = ""




    var email: String? = auth.currentUser.email




    suspend fun createuser (classe:Int, Nome: String?, Elemento: Int):String{
        println( "Repo create")

        val NewPlayer = Jogador(classe,Nome,Elemento,email)
        println(NewPlayer.nome)
        id = request.addplayer(NewPlayer)

        return id
    }

    suspend fun batalha(opcao: Int): Call<String> {
        var Id = request.getID(email)
        var Log = request.batalha(0,Id,opcao)



        return Log
    }
    suspend fun batalhaChefe(opcao: Int): Call<String> {
        var Id = request.getID(email)

        var Log = request.batalha(1,Id,opcao)

        return Log
    }

    suspend fun taverna(item: String): Call<String> {
        var Id = request.getID(email)

        var log = request.taverna(Id,item)

        return log

    }

    suspend fun trocaElm(elm: Int){
        var Id = request.getID(email)
        request.trocaelemento(Id, elm)
    }


}

