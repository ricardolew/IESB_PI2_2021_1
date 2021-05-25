package br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentCriarPersonagemOnboardingBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentOnboardingBinding
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.AdaptadorVP
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingFirstFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingSecondFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingThirdFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarFirstFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarSecondFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarThirdFragment


class CriarPersonagemOnboarding : Fragment() {

    private lateinit var binding: FragmentCriarPersonagemOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCriarPersonagemOnboardingBinding.inflate(inflater, container, false)

        binding.fragment=this
        binding.lifecycleOwner = this



        //fonte de dados
        val listaFragmentos = listOf(
            CriarFirstFragment(),
            CriarSecondFragment(),
            CriarThirdFragment()
        )

        //adaptador
        val adaptador = AdaptadorVPcriar(
            listaFragmentos,
            requireActivity().supportFragmentManager,
            lifecycle
        )


        binding.vpCriarOB.adapter = adaptador
        binding.WormDotsIndicator.setViewPager2(binding.vpCriarOB)

        return binding.root

    }


}

class AdaptadorVPcriar(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount() = listaFragmentos.size
    override fun createFragment(position: Int) = listaFragmentos[position]
}