package br.iesb.mobile.rpg_pi2_20211

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btEntrar.setOnClickListener {
            val email = etEmailLogin.text.toString()
            val senha = etSenhaLogin.text.toString()

            val auth = FirebaseAuth.getInstance()

            if(email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this, "Insira login e senha", Toast.LENGTH_LONG).show()
            } else {
                val taskLogin = auth.signInWithEmailAndPassword(email, senha)

                taskLogin.addOnCompleteListener { resultado ->
                    if(resultado.isSuccessful){
                        //val home = Intent(this, HomeActivity::class.java)
                        //startActivity(home)
                        Toast.makeText(this, "Logado com sucesso", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_LONG).show()
                    }

                }
            }
        }

        btCad.setOnClickListener {
            /*val redirecionar = Intent(this, CadastroActivity::class.java)
            startActivity(redirecionar)*/
        }

        tvEsqueci.setOnClickListener {
            //val redirecionar = Intent(this, EsqueciActivity::class.java)
            //startActivity(redirecionar)
        }
    }
}