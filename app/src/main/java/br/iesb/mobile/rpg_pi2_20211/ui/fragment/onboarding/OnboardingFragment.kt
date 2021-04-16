package br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentOnboardingBinding
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingFirstFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingSecondFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingThirdFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
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
        return binding.root
    }

    @SuppressWarnings
    fun start(){}
    
}

class AdaptadorVP(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter (fragmentManager, lifecycle){

    override fun getItemCount() = listaFragmentos.size
    override fun createFragment(position: Int) = listaFragmentos[position]
}