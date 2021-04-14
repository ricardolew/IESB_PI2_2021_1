package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.iesb.mobile.rpg_pi2_20211.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_cadastro.*

class CadastroFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btCadastroConfirma.setOnClickListener {

            val email = etEmailCadastro.text.toString()
            val senha = etSenhaCadastro.text.toString()
            val senhaConfirmada = etSenhaConfirmaCadastro.text.toString()

            val auth = FirebaseAuth.getInstance()

            if(email.isEmpty() or senha.isEmpty()){

                Toast.makeText(activity, "Digite o email e a senha desejada", Toast.LENGTH_LONG).show()
            }

            if(senha != senhaConfirmada){

                Toast.makeText(activity, "Digite a mesma senha", Toast.LENGTH_LONG).show()
            }
            else{

                val taskCadastro = auth.createUserWithEmailAndPassword(email, senha)

                taskCadastro.addOnCompleteListener{resultado ->

                    if(resultado.isSuccessful){

                        Toast.makeText(activity, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()

                        activity?.finish()

                    }
                    else{

                        Toast.makeText(activity, "Email já está sendo utilizado. Digite outro", Toast.LENGTH_LONG).show()
                    }


                }
            }
        }

        btCadastroVolta.setOnClickListener {

            activity?.finish()
        }
    }
}

