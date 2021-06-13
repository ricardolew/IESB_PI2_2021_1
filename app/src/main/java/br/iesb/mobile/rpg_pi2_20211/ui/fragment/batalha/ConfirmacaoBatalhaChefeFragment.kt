package br.iesb.mobile.rpg_pi2_20211.ui.fragment.batalha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentChatBotBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentConfirmacaoBatalhaChefeBinding
import br.iesb.mobile.rpg_pi2_20211.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class ConfirmacaoBatalhaChefeFragment : DialogFragment() {

    private lateinit var binding: FragmentConfirmacaoBatalhaChefeBinding
    private val Viewmodel: ChatViewModel by viewModels()


    var mensagem = MutableLiveData<String?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(DialogFragment.STYLE_NORMAL,android.R.style.ThemeOverlay_Material_Dialog_Alert)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmacaoBatalhaChefeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragment=this




        return binding.root
    }
    
    fun batalhachefe(v: View){
        findNavController().navigate(R.id.action_mapFragment_to_batalhaChefeFragment)
        this.dismiss()

    }



}