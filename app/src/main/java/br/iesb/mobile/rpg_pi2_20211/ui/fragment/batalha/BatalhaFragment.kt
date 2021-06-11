package br.iesb.mobile.rpg_pi2_20211.ui.fragment.batalha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentBatalhaBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentBatalhaFirstBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentMapBinding
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.AdaptadorVP
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarFirstFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarSecondFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarThirdFragment
import kotlin.random.Random


class BatalhaFragment : Fragment() {

    private lateinit var binding: FragmentBatalhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBatalhaBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
//
        var listaFragmentos = listOf<Fragment>()
        var batalha = 0
         batalha = (1..4).random()

//        if(batalha == 1){
//            listaFragmentos = BatalhaSecondFragment()
//        }else {
//            listaFragmentos = BatalhaFirstFragment()
//        }

        if(batalha > 0 || batalha < 3) {
             listaFragmentos = listOf(
                BatalhaFirstFragment()
            )
        }else if (batalha>2 || batalha<5){
            listaFragmentos = listOf(
                BatalhaSecondFragment()
            )
        }

        //adaptador
        val adaptador = AdaptadorBatalha(
            listaFragmentos,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.vpBatalha.adapter = adaptador
//        binding.WormDotsIndicator.setViewPager2(binding.vpBatalha)

        return binding.root
    }


}
class AdaptadorBatalha(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount() = listaFragmentos.size
    override fun createFragment(position: Int) = listaFragmentos[position]
}