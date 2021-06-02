package br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentCriarPersonagemOnboardingBinding
import br.iesb.mobile.rpg_pi2_20211.databinding.FragmentOnboardingBinding
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.AdaptadorVP
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingFirstFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingSecondFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.onboarding.screen.OnboardingThirdFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarFirstFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarSecondFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.personagem.screen.CriarThirdFragment
import br.iesb.mobile.rpg_pi2_20211.viewmodel.RpgApiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_criar_first.*
import kotlinx.android.synthetic.main.fragment_criar_personagem_onboarding.*

@AndroidEntryPoint
class CriarPersonagemOnboarding : Fragment() {

    private lateinit var binding: FragmentCriarPersonagemOnboardingBinding
    private val viewmodel: RpgApiViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentCriarPersonagemOnboardingBinding.inflate(inflater, container, false)

        binding.fragment=this
        binding.lifecycleOwner = this

        binding.viewmodel = viewmodel



        //fonte de dados
        val listaFragmentos = listOf(
            CriarFirstFragment(),
            CriarSecondFragment(),
            CriarThirdFragment()
        )

        //adaptador
        val adaptador = AdaptadorVPcriar(
            listaFragmentos,
            requireActivity().supportFragmentManager,
            lifecycle
        )


        binding.vpCriarOB.adapter = adaptador
        binding.WormDotsIndicator.setViewPager2(binding.vpCriarOB)

        return binding.root

    }

    @SuppressWarnings
    fun PopUpElement(v:View){

        val popup = PopupMenu(activity,btElmento)

        popup.inflate(R.menu.teste)

        popup.setOnMenuItemClickListener {
            val item = it.title.toString()
            viewmodel.elemento = item
            Toast.makeText(activity, "Item: " +it.title, Toast.LENGTH_SHORT).show()
            true

        }
        popup.show()
    }

    @SuppressWarnings
    fun start(v:View){
        var classe: Int = -1
        if (tvCriar.text.toString() == "Arqueiro"){
            classe = 1
        }
        else if (tvCriar.text.toString() == "Guerreiro") {
            classe = 2
        }
        else if (tvCriar.text.toString() == "Mago") {
            classe = 3
        }

        viewmodel.createUser(classe)
        println("Nav")
        findNavController().navigate(R.id.action_criarPersonagemOnboarding_to_personagemFragment)
    }

    @SuppressWarnings
    fun back(v: View){
        findNavController().popBackStack()
    }


}


class AdaptadorVPcriar(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount() = listaFragmentos.size
    override fun createFragment(position: Int) = listaFragmentos[position]
}