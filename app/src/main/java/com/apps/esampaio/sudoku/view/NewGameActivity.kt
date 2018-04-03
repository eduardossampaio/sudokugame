package com.apps.esampaio.sudoku.view

import android.content.Intent
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.apps.esampaio.sudoku.R
import com.apps.esampaio.sudoku.entity.SudokuNumber
import kotlinx.android.synthetic.main.activity_new_game.*

class NewGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        bt_new_game_easy.setOnClickListener {
            val game = hashMapOf(
                    Point(0,0) to SudokuNumber(5,true),
                    Point(1,0) to SudokuNumber(3,true),
                    Point(2,0) to SudokuNumber(4,false),
                    Point(3,0) to SudokuNumber(6,false),
                    Point(4,0) to SudokuNumber(7,true),
                    Point(5,0) to SudokuNumber(8,false),
                    Point(6,0) to SudokuNumber(9,false),
                    Point(7,0) to SudokuNumber(1,false),
                    Point(8,0) to SudokuNumber(2,false),

                    Point(0,1) to SudokuNumber(6,true),
                    Point(1,1) to SudokuNumber(7,false),
                    Point(2,1) to SudokuNumber(2,false),
                    Point(3,1) to SudokuNumber(1,true),
                    Point(4,1) to SudokuNumber(9,true),
                    Point(5,1) to SudokuNumber(5,true),
                    Point(6,1) to SudokuNumber(3,false),
                    Point(7,1) to SudokuNumber(4,false),
                    Point(8,1) to SudokuNumber(8,false),

                    Point(0,2) to SudokuNumber(1,false),
                    Point(1,2) to SudokuNumber(9,false),
                    Point(2,2) to SudokuNumber(8,false),
                    Point(3,2) to SudokuNumber(3,false),
                    Point(4,2) to SudokuNumber(4,false),
                    Point(5,2) to SudokuNumber(2,false),
                    Point(6,2) to SudokuNumber(5,false),
                    Point(7,2) to SudokuNumber(6,false),
                    Point(8,2) to SudokuNumber(7,false),

                    Point(0,3) to SudokuNumber(8,false),
                    Point(1,3) to SudokuNumber(5,false),
                    Point(2,3) to SudokuNumber(9,false),
                    Point(3,3) to SudokuNumber(7,false),
                    Point(4,3) to SudokuNumber(6,false),
                    Point(5,3) to SudokuNumber(1,false),
                    Point(6,3) to SudokuNumber(4,false),
                    Point(7,3) to SudokuNumber(2,false),
                    Point(8,3) to SudokuNumber(3,false),

                    Point(0,4) to SudokuNumber(4,false),
                    Point(1,4) to SudokuNumber(2,false),
                    Point(2,4) to SudokuNumber(6,false),
                    Point(3,4) to SudokuNumber(8,false),
                    Point(4,4) to SudokuNumber(5,false),
                    Point(5,4) to SudokuNumber(3,false),
                    Point(6,4) to SudokuNumber(7,false),
                    Point(7,4) to SudokuNumber(9,false),
                    Point(8,4) to SudokuNumber(1,false),

                    Point(0,5) to SudokuNumber(7,false),
                    Point(1,5) to SudokuNumber(1,false),
                    Point(2,5) to SudokuNumber(3,false),
                    Point(3,5) to SudokuNumber(9,false),
                    Point(4,5) to SudokuNumber(2,false),
                    Point(5,5) to SudokuNumber(4,false),
                    Point(6,5) to SudokuNumber(8,false),
                    Point(7,5) to SudokuNumber(5,false),
                    Point(8,5) to SudokuNumber(6,false),

                    Point(0,6) to SudokuNumber(9,false),
                    Point(1,6) to SudokuNumber(6,false),
                    Point(2,6) to SudokuNumber(1,false),
                    Point(3,6) to SudokuNumber(5,false),
                    Point(4,6) to SudokuNumber(3,false),
                    Point(5,6) to SudokuNumber(7,false),
                    Point(6,6) to SudokuNumber(2,false),
                    Point(7,6) to SudokuNumber(8,false),
                    Point(8,6) to SudokuNumber(4,false),

                    Point(0,7) to SudokuNumber(2,false),
                    Point(1,7) to SudokuNumber(8,false),
                    Point(2,7) to SudokuNumber(7,false),
                    Point(3,7) to SudokuNumber(4,false),
                    Point(4,7) to SudokuNumber(1,false),
                    Point(5,7) to SudokuNumber(9,false),
                    Point(6,7) to SudokuNumber(6,false),
                    Point(7,7) to SudokuNumber(3,false),
                    Point(8,7) to SudokuNumber(5,false),

                    Point(0,8) to SudokuNumber(3,false),
                    Point(1,8) to SudokuNumber(4,false),
                    Point(2,8) to SudokuNumber(5,false),
                    Point(3,8) to SudokuNumber(2,false),
                    Point(4,8) to SudokuNumber(8,false),
                    Point(5,8) to SudokuNumber(6,false),
                    Point(6,8) to SudokuNumber(1,false)
//                    Point(7,8) to SudokuNumber(7,false),
//                    Point(8,8) to SudokuNumber(9,false)



            );
            val intent = Intent(this,GameActivity::class.java);
            intent.putExtra("NUMBERS",game);
            startActivity(intent)
        }
    }
}
