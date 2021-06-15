package br.iesb.mobile.rpg_pi2_20211.repository

import br.iesb.mobile.rpg_pi2_20211.di.RpgApiService
import br.iesb.mobile.rpg_pi2_20211.domain.*
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import java.lang.Exception
import javax.inject.Inject


class RpgApiRepository @Inject constructor(
//    private val retrofit: Retrofit,

    private val request: RpgApiService,
    private var auth: FirebaseAuth

) {

    var id: String = ""




    var email: String? = auth.currentUser.email


    suspend fun getuser():Int{
        try {
            val req = request.getPersonagem(email).id
            return 1
        }catch (e: Exception){
            return 0
        }

    }

    suspend fun createuser (classe: Int?, Nome: String?, Elemento: Int):String{
        println( "Repo create")

        try {
                val NewPlayer = Jogador(classe, Nome, Elemento, email)
                println(NewPlayer.nome)
                id = request.addplayer(NewPlayer)


        }catch (e: Exception){
            id = "Você já tem um jogador"
        }
        return id


    }

    suspend fun nomeuser(): String?{
        var textview: Personagem? = null
        try {
             textview = request.getPersonagem(email)
        }finally {
            return textview?.nome
        }




    }

    suspend fun niveluser(): String{
        var nivel = -1
        try {
           nivel = request.getPersonagem(email).nivel
        }finally {
            return "Nível ${nivel}"
        }


    }

    suspend fun batalha(opcao: Int): BatalhaDTO {
        var Id = -1
        try {
            Id = request.getPersonagem(email).id
        }finally {
            var Log = request.batalha(0,Id.toString(),opcao)

            return Log
        }


    }
    suspend fun batalhaChefe(opcao: Int): BatalhaDTO {
        var Id: Int = -1
        try {
          Id = request.getPersonagem(email).id
        }finally {
            val Log = request.batalha(1,Id.toString(),opcao)

            return Log
        }
    }

    suspend fun taverna(item: String): Int {
        var Id = -1
        try {
             Id = request.getPersonagem(email).id


        }finally {
            var log = request.taverna(Id.toString(),item)
            return log

        }




    }

    suspend fun trocaElm(elm: Int){
        var Id =-1
        try {
           Id  = request.getPersonagem(email).id
        }finally {
            request.trocaelemento(Id.toString(), elm)
        }


    }

    suspend fun deletar(){
        request.deletar(email)
    }


}

