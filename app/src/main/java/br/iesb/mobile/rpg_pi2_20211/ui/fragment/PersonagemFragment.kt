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
import kotlinx.android.synthetic.main.fragment_personagem.*

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
//        binding.viewmodel = viewmodel

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
            Toast.makeText(activity, "Item: " +it.title, Toast.LENGTH_SHORT).show()
            true
        }
        popup.show()

    }



}
