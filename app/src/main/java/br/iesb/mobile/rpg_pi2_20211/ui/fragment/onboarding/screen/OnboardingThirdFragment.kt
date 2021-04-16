package br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentOnboardingSecondBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentOnboardingThirdBinding


class OnboardingThirdFragment : Fragment() {


    private lateinit var binding: FragmentOnboardingThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOnboardingThirdBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }


}