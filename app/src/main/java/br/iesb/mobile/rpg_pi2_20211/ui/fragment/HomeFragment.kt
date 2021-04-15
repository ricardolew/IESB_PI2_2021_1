package br.iesb.mobile.rpg_pi2_20211.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.rpg_pi2_20211.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btPersonagem1.setOnClickListener {

//            if (personagem.exists){
//            val redirecionar = Intent(activity, PersonagemActivity::class.java)
//            startActivity(redirecionar)
//             }
//            else{
//             val redirecionar = intent (activity, CriarPersonagemActivity::class.java)
//                         startActvity(redirecionar)
//             }

        }
        btPersonagem2.setOnClickListener{

            //if (personagem.exists){
//            val redirecionar = Intent(activity, PersonagemActivity::class.java)
//            startActivity(redirecionar)
//             }
//            else{
//             val redirecionar = intent (activity, CriarPersonagemActivity::class.java)
//                         startActvity(redirecionar)
//             }
        }
        btPersonagem3.setOnClickListener{

            //if (personagem.exists){
//            val redirecionar = Intent(activity, PersonagemActivity::class.java)
//            startActivity(redirecionar)
//             }
//            else{
//             val redirecionar = intent (activity, CriarPersonagemActivity::class.java)
//                         startActvity(redirecionar)
//             }
        }


    }
}
