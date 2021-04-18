package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.iesb.mobile.rpg_pi2_20211.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_esqueci.*

class EsqueciFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_esqueci, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            btEnviarEmail.setOnClickListener {
            val email = etEmailEsqueci.text.toString()

            val auth = FirebaseAuth.getInstance()
            if (email.isEmpty()) {
                Toast.makeText(activity, "Insira o email", Toast.LENGTH_LONG).show()
            }else{


            val taskEsqueci = auth.sendPasswordResetEmail(email)
                taskEsqueci.addOnCompleteListener { resultado ->
                    if (resultado.isSuccessful) {
                        Toast.makeText(activity, "E-mail de recuperação enviado! Favor verificar o correio eletrônico", Toast.LENGTH_LONG).show()

                        activity?.finish()
                    } else {
                        Toast.makeText(activity, "Email inválidos", Toast.LENGTH_LONG).show()
                    }
                }
//            Toast.makeText(this, "E-mail de recuperação enviado! Favor verificar o correio eletrônico", Toast.LENGTH_LONG).show()
//            finish()
        }

        }
        btVoltarEsqueci.setOnClickListener {

            activity?.finish()
        }
    }

}
