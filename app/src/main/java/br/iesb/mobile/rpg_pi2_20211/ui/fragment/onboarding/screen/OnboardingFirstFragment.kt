package br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentOnboardingFirstBinding


class OnboardingFirstFragment : Fragment() {

    private lateinit var binding : FragmentOnboardingFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOnboardingFirstBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root

    }


}