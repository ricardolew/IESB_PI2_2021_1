package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentHomeBinding
import br.iesb.mobile.rpg_pi2_20211.viewmodel.RpgApiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.loadData()

    }

    fun criarPersonagem (v: View) {
        findNavController().navigate(R.id.action_homeFragment_to_criarPersonagemOnboarding)
    }

    fun chatBot(v:View){
        findNavController().navigate(R.id.action_homeFragment_to_chatBotFragment)

    }

    fun map(v:View){
        findNavController().navigate(R.id.action_homeFragment_to_mapFragment)

    }
}
