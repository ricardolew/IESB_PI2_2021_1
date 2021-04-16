package br.iesb.mobile.netflics.ui.fragment.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentSplashscreenBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashscreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashscreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        GlobalScope.launch(context = Dispatchers.Main) {
            delay(4000)
            findNavController().navigate(R.id.action_splashScreenFragment_to_onboardingFragment4)
        }

        return binding.root
    }

}