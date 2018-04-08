package com.apps.esampaio.sudoku.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.apps.esampaio.sudoku.R
import com.apps.esampaio.sudoku.entity.Coordinate
import com.apps.esampaio.sudoku.entity.SudokuNumber
import kotlinx.android.synthetic.main.activity_new_game.*

class NewGameActivity : SuperActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        bt_new_game_easy.setOnClickListener {
            goToListActivity()
        }
        bt_new_game_medium.setOnClickListener {
            goToListActivity()
        }
        bt_new_game_hard.setOnClickListener {
            goToListActivity()
        }
    }

    private fun goToListActivity(){
        val intent = Intent(this,ListGamesActivity::class.java);
        startActivity(intent)
    }
}
