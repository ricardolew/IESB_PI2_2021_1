package br.iesb.mobile.rpg_pi2_20211

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btPersonagem1.setOnClickListener {
            val redirecionar = Intent(this, PersonagemActivity::class.java)
            startActivity(redirecionar)


            //if (personagem.exists){
            // val redirecionar = intent (this, MenuActivity::class.java)
            // startActvity(redirecionar)
            // }
            //else{
            //// val redirecionar = intent (this, CriarPersonagemActivity::class.java)
            //            // startActvity(redirecionar)
            // }
        }
    }
}