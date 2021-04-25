package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentLoginBinding
//import br.iesb.mobile.rpg_pi2_20211.ui.activity.antigos.CadastroActivity
//import br.iesb.mobile.rpg_pi2_20211.ui.activity.antigos.EsqueciActivity
//import br.iesb.mobile.rpg_pi2_20211.ui.activity.antigos.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    fun startCadastro(v: View){

        findNavController().navigate(R.id.action_loginFragment2_to_cadastroFragment)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.fragmentLogin = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btEntrar.setOnClickListener {
            val email = etEmailLogin.text.toString()
            val senha = etSenhaLogin.text.toString()

            val auth = FirebaseAuth.getInstance()

            if(email.isEmpty() || senha.isEmpty()){
                Toast.makeText(activity, "Insira login e senha", Toast.LENGTH_LONG).show()
            } else {
                val taskLogin = auth.signInWithEmailAndPassword(email, senha)

                taskLogin.addOnCompleteListener { resultado ->
                    if(resultado.isSuccessful){
                        //val redirecionar = Intent(activity, HomeActivity::class.java)
                        //startActivity(redirecionar)
                        Toast.makeText(activity, "Logado com sucesso", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(activity, "Email ou senha inválidos", Toast.LENGTH_LONG).show()
                    }


                }
            }
        }

        btCad.setOnClickListener {
            //val redirecionar = Intent(activity, CadastroActivity::class.java)
            //startActivity(redirecionar)
        }

        tvEsqueci.setOnClickListener {
            //val redirecionar = Intent(activity, EsqueciActivity::class.java)
            //startActivity(redirecionar)
        }
    }


}