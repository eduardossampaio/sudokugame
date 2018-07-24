package com.apps.esampaio.sudoku.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.apps.esampaio.sudoku.R
import com.apps.esampaio.sudoku.entity.Coordinate
import com.apps.esampaio.sudoku.entity.SudokuGame
import com.apps.esampaio.sudoku.entity.SudokuNumber
import com.apps.esampaio.sudoku.view.adapters.ListGamesAdapter
import com.beust.klaxon.Klaxon
import com.google.gson.GsonBuilder
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


        val sudokuNumbers = mutableListOf(
                SudokuNumber(Coordinate(0,0)  ,5,true),
                SudokuNumber(Coordinate(1,0)  ,3,true),
                SudokuNumber(Coordinate(2,0)  ,4,false),
                SudokuNumber(Coordinate(3,0)  ,6,false),
                SudokuNumber(Coordinate(4,0)  ,7,true),
                SudokuNumber(Coordinate(5,0)  ,8,false),
                SudokuNumber(Coordinate(6,0)  ,9,false),
                SudokuNumber(Coordinate(7,0)  ,1,false),
                SudokuNumber(Coordinate(8,0)  ,2,false),

                SudokuNumber(Coordinate(0,1)  ,6,true),
                SudokuNumber(Coordinate(1,1)  ,7,false),
                SudokuNumber(Coordinate(2,1)  ,2,false),
                SudokuNumber(Coordinate(3,1)  ,1,true),
                SudokuNumber(Coordinate(4,1)  ,9,true),
                SudokuNumber(Coordinate(5,1)  ,5,true),
                SudokuNumber(Coordinate(6,1)  ,3,false),
                SudokuNumber(Coordinate(7,1)  ,4,false),
                SudokuNumber(Coordinate(8,1)  ,8,false),

                SudokuNumber(Coordinate(0,2)  ,1,false),
                SudokuNumber(Coordinate(1,2)  ,9,false),
                SudokuNumber(Coordinate(2,2)  ,8,false),
                SudokuNumber(Coordinate(3,2)  ,3,false),
                SudokuNumber(Coordinate(4,2)  ,4,false),
                SudokuNumber(Coordinate(5,2)  ,2,false),
                SudokuNumber(Coordinate(6,2)  ,5,false),
                SudokuNumber(Coordinate(7,2)  ,6,false),
                SudokuNumber(Coordinate(8,2)  ,7,false),

                SudokuNumber(Coordinate(0,3)  ,8,false),
                SudokuNumber(Coordinate(1,3)  ,5,false),
                SudokuNumber(Coordinate(2,3)  ,9,false),
                SudokuNumber(Coordinate(3,3)  ,7,false),
                SudokuNumber(Coordinate(4,3)  ,6,false),
                SudokuNumber(Coordinate(5,3)  ,1,false),
                SudokuNumber(Coordinate(6,3)  ,4,false),
                SudokuNumber(Coordinate(7,3)  ,2,false),
                SudokuNumber(Coordinate(8,3)  ,3,false),

                SudokuNumber(Coordinate(0,4)  ,4,false),
                SudokuNumber(Coordinate(1,4)  ,2,false),
                SudokuNumber(Coordinate(2,4)  ,6,false),
                SudokuNumber(Coordinate(3,4)  ,8,false),
                SudokuNumber(Coordinate(4,4)  ,5,false),
                SudokuNumber(Coordinate(5,4)  ,3,false),
                SudokuNumber(Coordinate(6,4)  ,7,false),
                SudokuNumber(Coordinate(7,4)  ,9,false),
                SudokuNumber(Coordinate(8,4)  ,1,false),

                SudokuNumber(Coordinate(0,5)  ,7,false),
                SudokuNumber(Coordinate(1,5)  ,1,false),
                SudokuNumber(Coordinate(2,5)  ,3,false),
                SudokuNumber(Coordinate(3,5)  ,9,false),
                SudokuNumber(Coordinate(4,5)  ,2,false),
                SudokuNumber(Coordinate(5,5)  ,4,false),
                SudokuNumber(Coordinate(6,5)  ,8,false),
                SudokuNumber(Coordinate(7,5)  ,5,false),
                SudokuNumber(Coordinate(8,5)  ,6,false),

                SudokuNumber(Coordinate(0,6)  ,9,false),
                SudokuNumber(Coordinate(1,6)  ,6,false),
                SudokuNumber(Coordinate(2,6)  ,1,false),
                SudokuNumber(Coordinate(3,6)  ,5,false),
                SudokuNumber(Coordinate(4,6)  ,3,false),
                SudokuNumber(Coordinate(5,6)  ,7,false),
                SudokuNumber(Coordinate(6,6)  ,2,false),
                SudokuNumber(Coordinate(7,6)  ,8,false),
                SudokuNumber(Coordinate(8,6)  ,4,false),

                SudokuNumber(Coordinate(0,7)  ,2,false),
                SudokuNumber(Coordinate(1,7)  ,8,false),
                SudokuNumber(Coordinate(2,7)  ,7,false),
                SudokuNumber(Coordinate(3,7)  ,4,false),
                SudokuNumber(Coordinate(4,7)  ,1,false),
                SudokuNumber(Coordinate(5,7)  ,9,false),
                SudokuNumber(Coordinate(6,7)  ,6,false),
                SudokuNumber(Coordinate(7,7)  ,3,false),
                SudokuNumber(Coordinate(8,7)  ,5,false),

                SudokuNumber(Coordinate(0,8)  ,3,false),
                SudokuNumber(Coordinate(1,8)  ,4,false),
                SudokuNumber(Coordinate(2,8)  ,5,false),
                SudokuNumber(Coordinate(3,8)  ,2,false),
                SudokuNumber(Coordinate(4,8)  ,8,false),
                SudokuNumber(Coordinate(5,8)  ,6,false),
                SudokuNumber(Coordinate(6,8)  ,1,false)
        );

        val game = SudokuGame("Level 1",sudokuNumbers,"EASY")

        val gson = GsonBuilder().create()


//        val jsonPerson: String = gson.toJson(game)
//        Log.i("JSON_SUDOKU",jsonPerson)
//        val result = Klaxon().toJsonString(jsonPerson)

        this.games.add(SudokuGame("Level 1",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 2",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 3",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 4",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 5",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 6",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 7",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 9",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 10",sudokuNumbers,"EASY"))

        this.games.add(SudokuGame("Level 11",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 12",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 13",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 14",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 15",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 16",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 17",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 19",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 20",sudokuNumbers,"EASY"))

        this.games.add(SudokuGame("Level 21",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 22",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 23",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 24",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 25",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 26",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 27",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 29",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 30",sudokuNumbers,"EASY"))

        this.games.add(SudokuGame("Level 31",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 32",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 33",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 34",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 35",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 36",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 37",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 39",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 40",sudokuNumbers,"EASY"))

        this.games.add(SudokuGame("Level 41",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 42",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 43",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 44",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 45",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 46",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 47",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 49",sudokuNumbers,"EASY"))
        this.games.add(SudokuGame("Level 50",sudokuNumbers,"EASY"))

        val result = Klaxon().toJsonString(this.games)
        var i=0
        i = i++

    }


    private fun goToGameActivity(game:SudokuGame){
        val intent = Intent(this,GameActivity::class.java)
        intent.putExtra("NUMBERS",game);
        startActivity(intent)
    }
}
