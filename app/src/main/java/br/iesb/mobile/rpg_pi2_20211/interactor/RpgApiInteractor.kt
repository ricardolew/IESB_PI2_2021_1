package br.iesb.mobile.rpg_pi2_20211.interactor

import br.iesb.mobile.rpg_pi2_20211.domain.BatalhaDTO
import br.iesb.mobile.rpg_pi2_20211.repository.RpgApiRepository
import javax.inject.Inject

class RpgApiInteractor @Inject constructor(

    private val repo: RpgApiRepository
) {

    private fun elementotoInt (elemento: String?) : Int {
        var el:Int = 0

        if(elemento.toString() == "Água"){
            el = 1
        }else if (elemento.toString() == "Fogo"){
            el = 2
        }else if (elemento.toString() == "Natureza"){
            el=3
        }else if(elemento.toString() == "Ordem"){
            el=4
        }else if(elemento.toString() == "Caos"){
            el=5
        }else if(elemento.toString() == "Cura"){
            el=6
        }

        return el
    }

    suspend fun getuser() : Int{
        var ex = repo.getuser()
        return ex
    }

    suspend fun createuser (classe: Int?, Nome: String?, Elemento: String?): String{
        val el = elementotoInt(Elemento)
        println("interactor Create")
        var id = repo.createuser(classe, Nome, el)
        return id
    }

    suspend fun nomeuser(): String?{

        return repo.nomeuser()
    }

    suspend fun niveluser(): String{
        return repo.niveluser()
    }

    suspend fun batalha(opcao: Int): BatalhaDTO {
        var Log = repo.batalha(opcao)
        return Log
    }
    suspend fun batalhaChefe(opcao: Int): BatalhaDTO {
        var Log = repo.batalhaChefe(opcao)
        return Log
    }

    suspend fun taverna(item: String): Int {
        var log = repo.taverna(item)

         return log
    }

    suspend fun trocaElm(elm: Int){
        repo.trocaElm(elm)
    }

    suspend fun deletar (){
        repo.deletar()
    }
}