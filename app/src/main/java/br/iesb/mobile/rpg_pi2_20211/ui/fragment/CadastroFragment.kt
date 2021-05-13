package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentCadastroBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentEsqueciBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentLoginBinding
import br.iesb.mobile.rpg_pi2_20211.viewmodel.LoginViewModel
import br.iesb.mobile.rpg_pi2_20211.domain.LoginResult
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_cadastro.*

@AndroidEntryPoint
class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private val viewmodel: LoginViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragment = this
//        binding.viewmodel = viewmodel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewmodel.result.observe(viewLifecycleOwner) {
//            when (it) {
//                "OK" -> {
//                    requireActivity().finish()
//                    Toast.makeText(context, getText(R.string.signup_successfully), Toast.LENGTH_LONG).show()
//                }
//                else -> Toast.makeText(context, it, Toast.LENGTH_LONG).show()
//            }
//        }

    }

    @SuppressWarnings
    fun voltar(v: View){

    }


}

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
////    override fun onCreateView(inflater: LayoutInflater,
////                              container: ViewGroup?,
////                              savedInstanceState: Bundle?,
////    ): View {
////
////        binding = FragmentLoginBinding.inflate(inflater, container, false)
////        binding.fragmentLogin = this
////        binding.lifecycleOwner = this
////
////        return binding.root
////    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        btCadastroConfirma.setOnClickListener {
//
//            val email = etEmailCadastro.text.toString()
//            val senha = etSenhaCadastro.text.toString()
//            val senhaConfirmada = etSenhaConfirmaCadastro.text.toString()
//
//            val auth = FirebaseAuth.getInstance()
//
//            if(email.isEmpty() or senha.isEmpty()){
//
//                Toast.makeText(activity, "Digite o email e a senha desejada", Toast.LENGTH_LONG).show()
//            }
//
//            if(senha != senhaConfirmada){
//
//                Toast.makeText(activity, "Digite a mesma senha", Toast.LENGTH_LONG).show()
//            }
//            else{
//
//                val taskCadastro = auth.createUserWithEmailAndPassword(email, senha)
//
//                taskCadastro.addOnCompleteListener{resultado ->
//
//                    if(resultado.isSuccessful){
//
//                        Toast.makeText(activity, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
//
//                        activity?.finish()
//
//                    }
//                    else{
//
//                        Toast.makeText(activity, "Email já está sendo utilizado. Digite outro", Toast.LENGTH_LONG).show()
//                    }
//
//
//                }
//            }
//        }
//
//        btCadastroVolta.setOnClickListener {
//
//            activity?.finish()
//        }
//    }
//
////    fun voltar(v: View) {
////        findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment2)
////    }
//}
//
