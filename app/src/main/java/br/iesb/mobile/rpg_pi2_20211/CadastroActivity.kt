package br.iesb.mobile.rpg_pi2_20211

/*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btCadastroConfirma.setOnClickListener {

            val email = etEmailCadastro.text.toString()
            val senha = etSenhaCadastro.text.toString()
            val senhaConfirmada = etSenhaConfirmaCadastro.text.toString()

            val auth = FirebaseAuth.getInstance()

            if(email.isEmpty() or senha.isEmpty()){

                Toast.makeText(this, "Digite o email e a senha desejada", Toast.LENGTH_LONG).show()
            }

            if(senha != senhaConfirmada){

                Toast.makeText(this, "Digite a mesma senha", Toast.LENGTH_LONG).show()
            }
            else{

                val taskCadastro = auth.createUserWithEmailAndPassword(email, senha)

                taskCadastro.addOnCompleteListener(this){resultado ->

                    if(resultado.isSuccessful){

                        Log.d("CadastroSucesso", "Cadastro feito com sucesso")

                        val usuario = auth.currentUser

                    }
                    else{

                        Log.w("CadastroFalha", "Cadastro falhou", resultado.exception)

                        Toast.makeText(this, "Email já está sendo utilizado. Digite outro", Toast.LENGTH_LONG).show()
                    }


                }
            }
        }
    }
}*/
