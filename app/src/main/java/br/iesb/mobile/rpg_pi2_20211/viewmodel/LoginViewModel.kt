package br.iesb.mobile.rpg_pi2_20211.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.iesb.mobile.rpg_pi2_20211.domain.LoginResult
import br.iesb.mobile.rpg_pi2_20211.repository.LoginInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
        app: Application,
        private val interactor: LoginInteractor
) : AndroidViewModel(app) {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordCheck = MutableLiveData<String>()
    val result = MutableLiveData<LoginResult<Nothing>>()

    fun login() {
        viewModelScope.launch {
            result.value = interactor.login(email.value,password.value)

            }
        }


    }
//        viewModelScope.launch {
//            try {
//                result.value = interactor.login(email.value, password.value)
//            } catch (t: Throwable) {
//                Log.d("RPG", "[LOGIN] Error on login: ${t.localizedMessage}")
//                result.value = t.localizedMessage
//            }
//        }
//




//    fun signup() {
//        viewModelScope.launch {
//            try {
//                result.value = interactor.signup(email.value, password.value)
//            } catch (t: Throwable) {
//                Log.d("RPG", "[LOGIN] Error on signup: ${t.localizedMessage}")
//                result.value = t.localizedMessage
//            }
//        }
//    }
//
//    fun forgot() {
//        viewModelScope.launch {
//            try {
//                result.value = interactor.forgot(email.value)
//            } catch (t: Throwable) {
//                Log.d("RPG", "[LOGIN] Error on forgot password: ${t.localizedMessage}")
//                result.value = t.localizedMessage
//            }
//        }
//    }

