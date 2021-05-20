package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentCadastroBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentEsqueciBinding
import br.iesb.mobile.rpg_pi2_20211.domain.LoginResult
import br.iesb.mobile.rpg_pi2_20211.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_esqueci.*
import javax.inject.Inject

@AndroidEntryPoint
class EsqueciFragment : Fragment() {


    private lateinit var binding: FragmentEsqueciBinding
    private val viewmodel: LoginViewModel by viewModels()



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentEsqueciBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragment = this
        binding.viewmodel = viewmodel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.result.observe(viewLifecycleOwner) {
            when (it) {
                is LoginResult.Success -> {
                    requireActivity().finish()
                    Toast.makeText(context, getText(R.string.reset_password_email_sent), Toast.LENGTH_LONG).show()

                }
                else -> Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    @Suppress
    fun forgot(v: View) {

        viewmodel.forgot()
    }


}
//
//            btEnviarEmail.setOnClickListener {
//            val email = etEmailEsqueci.text.toString()
//
//            val auth = FirebaseAuth.getInstance()
//            if (email.isEmpty()) {
//                Toast.makeText(activity, "Insira o email", Toast.LENGTH_LONG).show()
//            }else{
//
//
//            val taskEsqueci = auth.sendPasswordResetEmail(email)
//                taskEsqueci.addOnCompleteListener { resultado ->
//                    if (resultado.isSuccessful) {
//                        Toast.makeText(activity, "E-mail de recuperação enviado! Favor verificar o correio eletrônico", Toast.LENGTH_LONG).show()
//
//                        activity?.finish()
//                    } else {
//                        Toast.makeText(activity, "Email inválidos", Toast.LENGTH_LONG).show()
//                    }
//                }
////            Toast.makeText(this, "E-mail de recuperação enviado! Favor verificar o correio eletrônico", Toast.LENGTH_LONG).show()
////            finish()
//        }
//
//        }
//        btVoltarEsqueci.setOnClickListener {
//
//            activity?.finish()
//        }
//    }


