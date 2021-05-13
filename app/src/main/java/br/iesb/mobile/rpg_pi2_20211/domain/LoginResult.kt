package br.iesb.mobile.rpg_pi2_20211.domain

//data class LoginData(val message: String?)

sealed class LoginResult<out T: Any> {
//    data class Success<out T: Any>(val data: T): LoginResult<T>()
//    data class Error(val error: Throwable): LoginResult<Nothing>()

    data class Success<out T: Any>(val value: T? = null): LoginResult<T>()
    data class Error(val message: String?, val error: Throwable?): LoginResult<Nothing>()
}
