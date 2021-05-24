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
        binding.viewmodel = viewmodel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.result.observe(viewLifecycleOwner) {
            when (it) {
                is LoginResult.Success -> {
                    findNavController().popBackStack()
                    Toast.makeText(
                        context,
                        getText(R.string.signup_successfully),
                        Toast.LENGTH_LONG
                    ).show()
                }
                is LoginResult.Error -> Toast.makeText(context, it.message, Toast.LENGTH_LONG)
                    .show()
            }
        }

    }

    @Suppress
    fun signup(v: View) {
        viewmodel.singnup()
    }

    @Suppress
    fun back (v: View) {
        findNavController().popBackStack()
    }
}

