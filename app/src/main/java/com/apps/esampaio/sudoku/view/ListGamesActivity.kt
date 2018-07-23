package com.apps.esampaio.sudoku.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.apps.esampaio.sudoku.R
import com.apps.esampaio.sudoku.entity.Coordinate
import com.apps.esampaio.sudoku.entity.SudokuGame
import com.apps.esampaio.sudoku.entity.SudokuNumber
import com.apps.esampaio.sudoku.view.adapters.ListGamesAdapter
import kotlinx.android.synthetic.main.activity_list_games.*

class ListGamesActivity : SuperActivity() {

    var games = mutableListOf<SudokuGame>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_games)
        initTestGame()
        val adapter = ListGamesAdapter(this,games)
        adapter.setItemSelectedListener{
            goToGameActivity(it)
        }
        list_games.adapter = adapter
        list_games.layoutManager = LinearLayoutManager(this)

    }

    private fun initTestGame() {

        val sudokuNumbers = hashMapOf(
                Coordinate(0,0) to SudokuNumber(5,true),
                Coordinate(1,0) to SudokuNumber(3,true),
                Coordinate(2,0) to SudokuNumber(4,false),
                Coordinate(3,0) to SudokuNumber(6,false),
                Coordinate(4,0) to SudokuNumber(7,true),
                Coordinate(5,0) to SudokuNumber(8,false),
                Coordinate(6,0) to SudokuNumber(9,false),
                Coordinate(7,0) to SudokuNumber(1,false),
                Coordinate(8,0) to SudokuNumber(2,false),

                Coordinate(0,1) to SudokuNumber(6,true),
                Coordinate(1,1) to SudokuNumber(7,false),
                Coordinate(2,1) to SudokuNumber(2,false),
                Coordinate(3,1) to SudokuNumber(1,true),
                Coordinate(4,1) to SudokuNumber(9,true),
                Coordinate(5,1) to SudokuNumber(5,true),
                Coordinate(6,1) to SudokuNumber(3,false),
                Coordinate(7,1) to SudokuNumber(4,false),
                Coordinate(8,1) to SudokuNumber(8,false),

                Coordinate(0,2) to SudokuNumber(1,false),
                Coordinate(1,2) to SudokuNumber(9,false),
                Coordinate(2,2) to SudokuNumber(8,false),
                Coordinate(3,2) to SudokuNumber(3,false),
                Coordinate(4,2) to SudokuNumber(4,false),
                Coordinate(5,2) to SudokuNumber(2,false),
                Coordinate(6,2) to SudokuNumber(5,false),
                Coordinate(7,2) to SudokuNumber(6,false),
                Coordinate(8,2) to SudokuNumber(7,false),

                Coordinate(0,3) to SudokuNumber(8,false),
                Coordinate(1,3) to SudokuNumber(5,false),
                Coordinate(2,3) to SudokuNumber(9,false),
                Coordinate(3,3) to SudokuNumber(7,false),
                Coordinate(4,3) to SudokuNumber(6,false),
                Coordinate(5,3) to SudokuNumber(1,false),
                Coordinate(6,3) to SudokuNumber(4,false),
                Coordinate(7,3) to SudokuNumber(2,false),
                Coordinate(8,3) to SudokuNumber(3,false),

                Coordinate(0,4) to SudokuNumber(4,false),
                Coordinate(1,4) to SudokuNumber(2,false),
                Coordinate(2,4) to SudokuNumber(6,false),
                Coordinate(3,4) to SudokuNumber(8,false),
                Coordinate(4,4) to SudokuNumber(5,false),
                Coordinate(5,4) to SudokuNumber(3,false),
                Coordinate(6,4) to SudokuNumber(7,false),
                Coordinate(7,4) to SudokuNumber(9,false),
                Coordinate(8,4) to SudokuNumber(1,false),

                Coordinate(0,5) to SudokuNumber(7,false),
                Coordinate(1,5) to SudokuNumber(1,false),
                Coordinate(2,5) to SudokuNumber(3,false),
                Coordinate(3,5) to SudokuNumber(9,false),
                Coordinate(4,5) to SudokuNumber(2,false),
                Coordinate(5,5) to SudokuNumber(4,false),
                Coordinate(6,5) to SudokuNumber(8,false),
                Coordinate(7,5) to SudokuNumber(5,false),
                Coordinate(8,5) to SudokuNumber(6,false),

                Coordinate(0,6) to SudokuNumber(9,false),
                Coordinate(1,6) to SudokuNumber(6,false),
                Coordinate(2,6) to SudokuNumber(1,false),
                Coordinate(3,6) to SudokuNumber(5,false),
                Coordinate(4,6) to SudokuNumber(3,false),
                Coordinate(5,6) to SudokuNumber(7,false),
                Coordinate(6,6) to SudokuNumber(2,false),
                Coordinate(7,6) to SudokuNumber(8,false),
                Coordinate(8,6) to SudokuNumber(4,false),

                Coordinate(0,7) to SudokuNumber(2,false),
                Coordinate(1,7) to SudokuNumber(8,false),
                Coordinate(2,7) to SudokuNumber(7,false),
                Coordinate(3,7) to SudokuNumber(4,false),
                Coordinate(4,7) to SudokuNumber(1,false),
                Coordinate(5,7) to SudokuNumber(9,false),
                Coordinate(6,7) to SudokuNumber(6,false),
                Coordinate(7,7) to SudokuNumber(3,false),
                Coordinate(8,7) to SudokuNumber(5,false),

                Coordinate(0,8) to SudokuNumber(3,false),
                Coordinate(1,8) to SudokuNumber(4,false),
                Coordinate(2,8) to SudokuNumber(5,false),
                Coordinate(3,8) to SudokuNumber(2,false),
                Coordinate(4,8) to SudokuNumber(8,false),
                Coordinate(5,8) to SudokuNumber(6,false),
                Coordinate(6,8) to SudokuNumber(1,false)
        );

        this.games.add(SudokuGame("Level 1",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 2",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 3",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 4",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 5",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 6",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 7",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 9",sudokuNumbers,"EASY"))
    }


    private fun goToGameActivity(game:SudokuGame){
        val intent = Intent(this,GameActivity::class.java)
        intent.putExtra("NUMBERS",game);
        startActivity(intent)
    }
}
