package br.iesb.mobile.rpg_pi2_20211.ui.fragment.batalha

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentBatalhaBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentBatalhaFirstBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentMapBinding
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.AdaptadorVP
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarFirstFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarSecondFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarThirdFragment
import br.iesb.mobile.rpg_pi2_20211.viewmodel.RpgApiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

@AndroidEntryPoint
class BatalhaFragment : Fragment() {

    private lateinit var binding: FragmentBatalhaBinding
    private val viewmodel: RpgApiViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBatalhaBinding.inflate(inflater, container, false)

        var listaFragmentos = listOf<Fragment>()
        var batalha = (1..4).random()


        if(batalha == 1) {
             listaFragmentos = listOf(
                BatalhaFirstFragment()
            )
        }else if (batalha == 2){
            listaFragmentos = listOf(
                BatalhaSecondFragment()
            )
        }else if (batalha == 3){
            listaFragmentos = listOf(
                BatalhaThirdFragment()
            )
        }else{
            listaFragmentos = listOf(
                BatalhaFourthFragment()
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

        binding.viewmodel = viewmodel


        viewmodel.lobBatalha.observe(viewLifecycleOwner){

            Toast.makeText(context, it.mensagemInicio, Toast.LENGTH_LONG).show()

            if(it.mensagemFugir != ""){
                Toast.makeText(context, it.mensagemFugir , Toast.LENGTH_LONG).show()
                findNavController().popBackStack()
            }else{
                if(it.mensagemFim != "") {
                    if (it.mensagemVitoria!="") {
                        Toast.makeText(
                            context,
                            it.mensagemVitoria + it.mensagemTurnoJogador + it.mensagemTurnoMonstro,
                            Toast.LENGTH_LONG
                        ).show()
                        findNavController().popBackStack()
                    }
                    if(it.mensagemDerrota !=""){
                        Toast.makeText(
                            context,
                            it.mensagemDerrota + it.mensagemTurnoJogador + it.mensagemTurnoMonstro,
                            Toast.LENGTH_LONG
                        ).show()
                        findNavController().popBackStack()
                    }
                }
                Toast.makeText(context, it.mensagemTurnoJogador+it.mensagemTurnoMonstro , Toast.LENGTH_LONG).show()

            }
        }

        return binding.root
    }

//    fun batalha(button: Int){
//
////        val button = v.id
//        GlobalScope.launch{
//            var log  = viewmodel.batalha(button)
//            if(button == 4){
//                Toast.makeText(context, log.mensagemFugir, Toast.LENGTH_LONG).show()
//                findNavController().popBackStack()
//            }else{
//                if(log.mensagemFim != "") {
//                    if (log.mensagemVitoria!="") {
//                        Toast.makeText(
//                            context,
//                            log.mensagemVitoria + log.mensagemTurnoJogador + log.mensagemTurnoMonstro,
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                    if(log.mensagemDerrota !=""){
//                        Toast.makeText(
//                            context,
//                            log.mensagemDerrota + log.mensagemTurnoJogador + log.mensagemTurnoMonstro,
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                }
//                Toast.makeText(context, log.mensagemTurnoJogador+log.mensagemTurnoMonstro , Toast.LENGTH_LONG).show()
//                findNavController().popBackStack()
//
//            }
        }


//        viewmodel.batalha(button)
//        val log = viewmodel.result
//        Toast.makeText(context, log.value, Toast.LENGTH_LONG).show()

//        }
//
//
//    }




class AdaptadorBatalha(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount() = listaFragmentos.size
    override fun createFragment(position: Int) = listaFragmentos[position]
}