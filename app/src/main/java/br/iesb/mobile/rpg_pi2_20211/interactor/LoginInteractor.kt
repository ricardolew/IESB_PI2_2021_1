package br.iesb.mobile.rpg_pi2_20211.repository

import android.app.Application
import android.util.Patterns
import br.iesb.mobile.rpg_pi2_20211.repository.LoginRepository
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.domain.LoginResult
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class LoginInteractor @Inject constructor (
        private val repo: LoginRepository,
        private val app: Application
) {

    private fun validadeEmailAndPassword(
            email: String?,
            password: String?,
    ): Pair<Pair<String, String>?, Throwable?> {

        if (email.isNullOrBlank()) return Pair(null, Exception(app.getString(R.string.email_required)))

        if (password.isNullOrBlank()) return Pair(null, Exception(app.getString(R.string.password_required)))

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return Pair(null, Exception(app.getString(R.string.invalid_email)))
        }

        if (password.length < 6) {
            return Pair(null, Exception(app.getString(R.string.password_minimum_length)))
        }

        return Pair(Pair(email, password), null)
    }

//    private fun validadeEmailAndPassword(email: String?, password: String?): Pair<String, String> {
//        if (email.isNullOrBlank()) {
//            throw Exception(app.getString(R.string.email_required))
//        }
//
//        if (password.isNullOrBlank()) {
//            throw Exception(app.getString(R.string.password_required))
//        }
//
//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            throw Exception(app.getString(R.string.invalid_email))
//        }
//
//        if (password.length < 6) {
//            throw Exception(app.getString(R.string.password_minimum_length))
//        }
//
//        return Pair(email, password)
//    }

    suspend fun login(email: String?, password: String?): LoginResult<Nothing> {
        val (credential, ex) = validadeEmailAndPassword(email, password)
        return when (ex) {
            null -> repo.login(credential!!.first, credential.second)
            else -> LoginResult.Error(ex.localizedMessage, ex)
        }
    }

    suspend fun forgot(email: String?): LoginResult<Nothing> {
        if (email.isNullOrBlank()) {
            throw Exception(app.getString(R.string.email_required))
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            throw Exception(app.getString(R.string.invalid_email))
        }

        return repo.forgot(email)
    }

    suspend fun singup(email: String?, password: String?): LoginResult<Nothing> {
        val (credential, ex) = validadeEmailAndPassword(email, password)
        return when (ex){
            null -> repo.signup(credential!!.first, credential.second)
            else -> LoginResult.Error(ex.localizedMessage, ex)
        }
    }
}





//    suspend fun signup(email: String?, password: String?): String {
//        val (e, p) = validadeEmailAndPassword(email, password)
//        return repo.signup(e, p)
//    }
//
//    suspend fun forgot(email: String?): String {
//        if (email.isNullOrBlank()) {
//            throw Exception(app.getString(R.string.email_required))
//        }
//
//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            throw Exception(app.getString(R.string.invalid_email))
//        }
//
//        return repo.forgot(email)
//    }
//
//}