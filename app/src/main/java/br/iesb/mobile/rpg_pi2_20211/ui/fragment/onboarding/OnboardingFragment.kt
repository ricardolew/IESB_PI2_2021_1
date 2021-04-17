package br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentOnboardingBinding
import br.iesb.mobile.rpg_pi2_20211.ui.activity.AppActivity
import br.iesb.mobile.rpg_pi2_20211.ui.activity.loginActivity
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingFirstFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingSecondFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingThirdFragment
import kotlinx.android.synthetic.main.fragment_onboarding.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        binding.fragment=this
        binding.lifecycleOwner = this



        //fonte de dados
        val listaFragmentos = listOf(
            OnboardingFirstFragment(),
            OnboardingSecondFragment(),
            OnboardingThirdFragment()
        )

        //adaptador
        val adaptador = AdaptadorVP(
            listaFragmentos,
            requireActivity().supportFragmentManager,
            lifecycle
        )




        binding.vpOnboarding.adapter = adaptador
        binding.WormDotsIndicator.setViewPager2(binding.vpOnboarding)

        return binding.root



    }

    @SuppressWarnings
    fun start(v:View){
        findNavController().navigate(R.id.action_onboardingFragment4_to_loginFragment2)
    }
    
}

class AdaptadorVP(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter (fragmentManager, lifecycle){

    override fun getItemCount() = listaFragmentos.size
    override fun createFragment(position: Int) = listaFragmentos[position]
}