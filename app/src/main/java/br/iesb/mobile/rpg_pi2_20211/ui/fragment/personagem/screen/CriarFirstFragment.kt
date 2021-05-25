package br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentCriarFirstBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentOnboardingFirstBinding


class CriarFirstFragment : Fragment() {


    private lateinit var binding: FragmentCriarFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCriarFirstBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root



    }


}