package br.iesb.mobile.rpg_pi2_20211.viewmodel

import android.app.Application
import android.telecom.Call
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.iesb.mobile.rpg_pi2_20211.domain.Jogador
import br.iesb.mobile.rpg_pi2_20211.interactor.RpgApiInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RpgApiViewModel @Inject constructor(
    app: Application,
    private val interactor: RpgApiInteractor
) : AndroidViewModel(app) {

    val nome = MutableLiveData<String>()
//    var elemento = MutableLiveData<String>()
     var elemento : String = ""




    fun loadData() {
        viewModelScope.launch {
            val characters = interactor.loadData()
//                Log.d("RPG_TESTE", "${characters}")
            characters.body()?.forEach() { c ->
                var classeS: String = ""
                if (c.classe == 1) {
                    classeS = "Arqueiro"
                } else if (c.classe == 2) {
                    classeS = "Guerreiro"
                } else if (c.classe == 3) {
                    classeS = "Mago"
                }
                var elementoS: String = ""
                if (c.elemento == 1) {
                    elementoS = "Agua"
                } else if (c.elemento == 2) {
                    elementoS = "Fogo"
                } else if (c.elemento == 3) {
                    elementoS = "Ar"
                } else if (c.elemento == 4) {
                    elementoS = "Terra"
                }

                Log.d("deee", "Nome: ${c.nome} - Classe: ${classeS} - Elemento: ${elementoS}")
            }
            Log.d("deee", "Json " + characters.body().toString())
        }
    }

    fun createUser(classe: Int) {
        viewModelScope.launch {
            println("vm create")
           val id = interactor.createuser(classe,nome.value,elemento)
            println(id)
        }
    }
}