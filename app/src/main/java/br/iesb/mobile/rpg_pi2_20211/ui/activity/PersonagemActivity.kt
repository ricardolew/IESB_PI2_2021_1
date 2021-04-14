package br.iesb.mobile.rpg_pi2_20211.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.rpg_pi2_20211.R
import kotlinx.android.synthetic.main.activity_personagem.*

class PersonagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personagem)

        btCharInfos.setOnClickListener {

        }
        btCharSpells.setOnClickListener {

        }
        btCharInv.setOnClickListener {

        }
        btCharTaverna.setOnClickListener {

        }
        btCharMap.setOnClickListener {

        }
    }
}