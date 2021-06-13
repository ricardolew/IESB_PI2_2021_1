package br.iesb.mobile.rpg_pi2_20211.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.iesb.mobile.rpg_pi2_20211.domain.LoginResult
import br.iesb.mobile.rpg_pi2_20211.repository.LoginInteractor
import br.iesb.mobile.rpg_pi2_20211.repository.RpgApiRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
        app: Application,
        private val interactor: LoginInteractor,
//        private val repo: RpgApiRepository
) : AndroidViewModel(app) {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordCheck = MutableLiveData<String>()
    val result = MutableLiveData<LoginResult<Nothing>>()

    fun login() {
        viewModelScope.launch {
            result.value = interactor.login(email.value,password.value)
//            repo.email = email.value

            }
        }

    fun forgot(){
        viewModelScope.launch {
            result.value = interactor.forgot(email.value)
        }
    }

    fun singnup() {
        viewModelScope.launch {
            result.value = interactor.singup(email.value, password.value)
        }
    }


    }



