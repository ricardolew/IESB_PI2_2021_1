package br.iesb.mobile.rpg_pi2_20211.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.iesb.mobile.rpg_pi2_20211.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_esqueci.*

class EsqueciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci)

        btEnviarEmail.setOnClickListener {
            val email = etEmailEsqueci.text.toString()

            val auth = FirebaseAuth.getInstance()
            if (email.isEmpty()) {
                Toast.makeText(this, "Insira o email", Toast.LENGTH_LONG).show()
            }else{


            val taskEsqueci = auth.sendPasswordResetEmail(email)
                taskEsqueci.addOnCompleteListener { resultado ->
                    if (resultado.isSuccessful) {
                        Toast.makeText(this, "E-mail de recuperação enviado! Favor verificar o correio eletrônico", Toast.LENGTH_LONG).show()

                        finish()
                    } else {
                        Toast.makeText(this, "Email inválidos", Toast.LENGTH_LONG).show()
                    }
                }
//            Toast.makeText(this, "E-mail de recuperação enviado! Favor verificar o correio eletrônico", Toast.LENGTH_LONG).show()
//            finish()
        }

        }
        btVoltarEsqueci.setOnClickListener {

            finish()
        }

    }
}