package br.iesb.mobile.rpg_pi2_20211.viewmodel

import android.app.Application
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.domain.Jogador
import br.iesb.mobile.rpg_pi2_20211.domain.LoginResult
import br.iesb.mobile.rpg_pi2_20211.interactor.RpgApiInteractor
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.batalha.BatalhaFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log


@HiltViewModel
class RpgApiViewModel @Inject constructor(
    app: Application,
    private val interactor: RpgApiInteractor
) : AndroidViewModel(app) {

    val nome = MutableLiveData<String>()
//    var elemento = MutableLiveData<String>()
    var elemento : String = ""
    var item: String = ""

    var opcao: String = ""
    var acao: String = ""

    var result = ""





    fun createUser(classe: Int) {
        viewModelScope.launch {
            println("vm create")
           var id = interactor.createuser(classe,nome.value,elemento)
            Log.d("CREATE", id.toString())
        }
    }

    fun batalha(button: Int){

//        val button = v.id

        var retorno = 0


        viewModelScope.launch {
            if (button == 4){
                findNavController().popBackStack()
            }
            val log = interactor.batalha(button)
            Log.d("BATALHA", log.toString())

        }
    }

    fun batalhaChefe(button: Int){

        viewModelScope.launch {
            result = interactor.batalhaChefe(button).toString()

        }

    }

    fun taverna(){

        viewModelScope.launch {
           val log = interactor.taverna(item)
            Log.d("TAVERNA", log)
        }

    }
}