package br.iesb.mobile.rpg_pi2_20211.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.iesb.mobile.rpg_pi2_20211.domain.BatalhaDTO
import br.iesb.mobile.rpg_pi2_20211.domain.Personagem
import br.iesb.mobile.rpg_pi2_20211.interactor.RpgApiInteractor
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.PersonagemFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.batalha.BatalhaFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RpgApiViewModel @Inject constructor(
    app: Application,
    private val interactor: RpgApiInteractor
) : AndroidViewModel(app) {

    val nome = MutableLiveData<String>()

    var elemento: String = ""
    var item: String = ""
    var elm: Int = -1

    var acao: String = ""

    var result = MutableLiveData<String>()
    var resultChefe = MutableLiveData<String>()
    var resultUser = MutableLiveData<Int>()
    var userName = MutableLiveData<String>()
    var userNivel = MutableLiveData<String>()
    var userBuy = MutableLiveData<Int>()
    var lobBatalha = MutableLiveData<BatalhaDTO>()
    var lobBatalhaChefe = MutableLiveData<BatalhaDTO>()



    var tv = ""

    var existe = -1

    suspend fun getuser() {
        viewModelScope.launch {
            resultUser.postValue(interactor.getuser())
        }
    }




    fun createUser(classe: Int?): String {
        viewModelScope.launch {
            println("vm create")
            tv = interactor.createuser(classe, nome.value, elemento)
            Log.d("CREATE", tv)


        }
        return tv
    }

    fun nomeuser(){
        viewModelScope.launch {
            userName.postValue(interactor.nomeuser().toString())
        }
    }

    fun niveluser(){
        viewModelScope.launch {
            userNivel.postValue(interactor.niveluser())
        }
    }

    fun batalha(button: Int) {
        viewModelScope.launch {
            lobBatalha.value = interactor.batalha(button)

        }

    }

    fun batalhaChefe(button: Int) {
        viewModelScope.launch {

                lobBatalhaChefe.value = interactor.batalhaChefe(button)



        }
    }

    fun taverna() {
            viewModelScope.launch {
                val log = interactor.taverna(item)
                Log.d("TAVERNA", log.toString())
//                if(log == 1) {
//                    PersonagemFragment().taverna("Parabéns pela compra do item")
//                }else{
//                    PersonagemFragment().taverna("Você não conseguiu comprar")

                }
            }



    fun trocaElemento() {

            viewModelScope.launch {
                interactor.trocaElm(elm)
            }

        }

    fun deletar(){
        viewModelScope.launch {
            interactor.deletar()


        }
    }
    }
