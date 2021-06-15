package br.iesb.mobile.rpg_pi2_20211.ui.fragment.batalha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentBatalhaChefeBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentBatalhaFourthBinding
import br.iesb.mobile.rpg_pi2_20211.domain.Chat
import br.iesb.mobile.rpg_pi2_20211.viewmodel.RpgApiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BatalhaChefeFragment : Fragment() {
    private lateinit var binding: FragmentBatalhaChefeBinding
    private val viewmodel: RpgApiViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBatalhaChefeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel=viewmodel

        viewmodel.lobBatalhaChefe.observe(viewLifecycleOwner){

            Toast.makeText(context, it.mensagemInicio, Toast.LENGTH_LONG).show()
            if(it.mensagemFugir != ""){
                Toast.makeText(context, "Você não pode fugir com suas pernas tremendo!" , Toast.LENGTH_LONG).show()
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

// fun batalhaChefe(button: Int) {
//
//     GlobalScope.launch{
//         var log = viewmodel.batalha(button)
//         if (button == 4) {
//             Toast.makeText(context, log.mensagemFugir, Toast.LENGTH_LONG).show()
//         } else {
//             if (log.mensagemFim != "") {
//                 if (log.mensagemVitoria != "") {
//                     Toast.makeText(
//                         context,
//                         log.mensagemVitoria + log.mensagemTurnoJogador + log.mensagemTurnoMonstro,
//                         Toast.LENGTH_LONG
//                     ).show()
//                 }
//                 if (log.mensagemDerrota != "") {
//                     Toast.makeText(
//                         context,
//                         log.mensagemDerrota + log.mensagemTurnoJogador + log.mensagemTurnoMonstro,
//                         Toast.LENGTH_LONG
//                     ).show()
//                 }
//             }
//             Toast.makeText(
//                 context,
//                 log.mensagemTurnoJogador + log.mensagemTurnoMonstro,
//                 Toast.LENGTH_LONG
//             ).show()
//             findNavController().popBackStack()
//
//         }
//     }



 }

