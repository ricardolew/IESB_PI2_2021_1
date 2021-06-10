package br.iesb.mobile.rpg_pi2_20211.interactor

import br.iesb.mobile.rpg_pi2_20211.domain.Jogador
import br.iesb.mobile.rpg_pi2_20211.repository.RpgApiRepository
import retrofit2.Call
import retrofit2.Response
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
        }

        return el
    }

    suspend fun loadData() : Response<List<Jogador>> {
        return repo.loadData()
    }

    suspend fun createuser (classe:Int, Nome: String?, Elemento: String?){
        val el = elementotoInt(Elemento)
        println("interactor Create")
        repo.createuser(classe, Nome, el)



    }
}