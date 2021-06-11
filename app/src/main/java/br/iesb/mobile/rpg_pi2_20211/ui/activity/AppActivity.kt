package br.iesb.mobile.rpg_pi2_20211.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.rpg_pi2_20211.R
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.chatbot.ChatBotFragment
import br.iesb.mobile.rpg_pi2_20211.ui.fragment.chatbot.ChatBotFragment_GeneratedInjector
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.android.synthetic.main.activity_app.*
import kotlinx.coroutines.Dispatchers.Main

@AndroidEntryPoint
@WithFragmentBindings
class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)


        ibChat.setOnClickListener{
            getSupportFragmentManager().beginTransaction().replace(R.id.appNavigationFragment, ChatBotFragment()).commit()
//            val intent = Intent (this, ChatBotFragment()::class.java)
//            this.startActivity(intent)
        }

    }

}