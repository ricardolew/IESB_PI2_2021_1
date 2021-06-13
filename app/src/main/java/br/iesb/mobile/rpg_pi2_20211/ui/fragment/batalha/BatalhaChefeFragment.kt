package br.iesb.mobile.rpg_pi2_20211.ui.fragment.batalha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentBatalhaChefeBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentBatalhaFourthBinding
import br.iesb.mobile.rpg_pi2_20211.viewmodel.RpgApiViewModel
import dagger.hilt.android.AndroidEntryPoint

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

        return binding.root
    }

    fun batalhaChefe(button: Int){
        val log = viewmodel.batalhaChefe(button)
    }

}
