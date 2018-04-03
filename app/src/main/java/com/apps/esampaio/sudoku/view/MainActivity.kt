package com.apps.esampaio.sudoku.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.apps.esampaio.sudoku.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_new_game.setOnClickListener {
            goToNewGame()
        }
        bt_score.setOnClickListener{

        }
        bt_tutorial.setOnClickListener {

        }
    }

    private fun goToNewGame() {
        startActivity(Intent(this,NewGameActivity::class.java))
    }
}
