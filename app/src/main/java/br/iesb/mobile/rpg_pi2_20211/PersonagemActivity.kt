package br.iesb.mobile.rpg_pi2_20211

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
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