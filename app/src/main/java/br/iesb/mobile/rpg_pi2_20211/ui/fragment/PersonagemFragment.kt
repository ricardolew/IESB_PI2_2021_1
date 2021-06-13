package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentPersonagemBinding
import br.iesb.mobile.rpg_pi2_20211.viewmodel.RpgApiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_personagem.*

@AndroidEntryPoint
class PersonagemFragment : Fragment() {

    private lateinit var binding: FragmentPersonagemBinding
    private val viewmodel: RpgApiViewModel by viewModels()



    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?,
                         ): View {

        binding = FragmentPersonagemBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragmentPersonagem = this
        binding.viewmodel=viewmodel

        return binding.root
    }


    fun map(v:View){
        findNavController().navigate(R.id.action_personagemFragment_to_mapFragment)

    }

    @SuppressWarnings
    fun PopUpLoja(v:View){

        val popup = PopupMenu(activity,btCharInv)

        popup.inflate(R.menu.taverna)


        popup.setOnMenuItemClickListener {
            val item = it.title.toString()
            viewmodel.item = item
            viewmodel.taverna()
            Toast.makeText(activity, "Item: " +it.title, Toast.LENGTH_SHORT).show()
            true
        }
        popup.show()

    }

    fun PopUpTrocaEl(v:View){

        val popup = PopupMenu(activity,btCharSpells)

        popup.inflate(R.menu.trocaelemento)


        popup.setOnMenuItemClickListener {
            val item = it.title.toString()
            if(item == "Água"){
                viewmodel.elm = 1
            }else if (item == "Fogo"){
                viewmodel.elm = 2
            }else if (item == "Natureza"){
                viewmodel.elm=3
            }else if(item == "Ordem"){
                viewmodel.elm=4
            }else if(item == "Caos"){
                viewmodel.elm=5
            }else if(item == "Cura"){
                viewmodel.elm=6
            }

            viewmodel.trocaElemento()
            Toast.makeText(activity, "Item: " +it.title, Toast.LENGTH_SHORT).show()
            true
        }
        popup.show()
    }



}
