package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentHomeBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentPersonagemBinding
import kotlinx.android.synthetic.main.fragment_personagem.*

class PersonagemFragment : Fragment() {

    private lateinit var binding: FragmentPersonagemBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonagemBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragmentPersonagem = this
//        binding.viewmodel = viewmodel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btCharInfos.setOnClickListener {

        }
        btCharSpells.setOnClickListener {

        }
        btCharInv.setOnClickListener {

        }
        btCharTaverna.setOnClickListener {

        }
        btCharMap.setOnClickListener {

        }
    }


    fun map(v:View){
        findNavController().navigate(R.id.action_personagemFragment_to_mapFragment)

    }

}
