package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentHomeBinding
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.batalha.ConfirmacaoBatalhaChefeFragment
import br.iesb.mobile.rpg_pi2_20211.viewmodel.RpgApiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_criar_personagem_onboarding.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewmodel: RpgApiViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragmentHome = this
//        binding.viewmodel = viewmodel

        viewmodel.resultUser.observe(viewLifecycleOwner){

            if(it == 1) {
                Toast.makeText(context,"Você já tem um jogador",Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_homeFragment_to_personagemFragment)
            }else{
                findNavController().navigate(R.id.action_homeFragment_to_criarPersonagemOnboarding)
            }
        }

        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//
//    }

//    fun start(v:View){
//
//        findNavController().navigate(R.id.action_homeFragment_to_personagemFragment)
//    }

   fun criarPersonagem (v: View) {
        GlobalScope.launch {
            viewmodel.getuser()
        }
        }



    fun chatBot(v:View){
        findNavController().navigate(R.id.action_homeFragment_to_chatBotFragment)

    }

    fun image(v: View){
        ConfirmacaoBatalhaChefeFragment().show(requireActivity().supportFragmentManager,"ChatBot")
    }

    @SuppressWarnings
    fun PopUpLoja(v:View){

        val popup = PopupMenu(activity,btElmento)

        popup.inflate(R.menu.popup)


        popup.setOnMenuItemClickListener {
            val item = it.title.toString()
            viewmodel.elemento = item
            Toast.makeText(activity, "Item: " +it.title, Toast.LENGTH_SHORT).show()
            true
        }
        popup.show()

    }

}
