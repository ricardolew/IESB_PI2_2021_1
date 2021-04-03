package br.iesb.mobile.rpg_pi2_20211

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_esqueci.*

class EsqueciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci)

        btEnviarEmail.setOnClickListener {
            val email = etEmailEsqueci.text.toString()
            val auth = FirebaseAuth.getInstance()
            auth.sendPasswordResetEmail(email)
            Toast.makeText(this, "E-mail de recuperação enviado! Favor verificar o correio eletrônico", Toast.LENGTH_LONG).show()
            finish()
        }

    }
}