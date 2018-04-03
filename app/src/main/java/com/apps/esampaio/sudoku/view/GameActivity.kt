package com.apps.esampaio.sudoku.view

import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.apps.esampaio.sudoku.R
import com.apps.esampaio.sudoku.entity.Coordinate
import com.apps.esampaio.sudoku.entity.SudokuGame
import com.apps.esampaio.sudoku.entity.SudokuNumber
import com.apps.esampaio.sudoku.view.custom.SudokuBoardListener
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_game.sudoku_board_view as sudokuBoard

class GameActivity : AppCompatActivity(), SudokuBoardListener {

    var numberClicked: String? = null
    var selectedPositionX: Int = -1
    var selectedPositionY: Int = -1
    var sudokuGame:SudokuGame = SudokuGame();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        sudokuBoard.listener = this
        val game = intent.extras["NUMBERS"] as HashMap<Coordinate,SudokuNumber>
        sudokuGame = SudokuGame(game)
        sudokuBoard.sudokuGame = sudokuGame
    }

    fun numberClicked(view: View) {
        if (view is TextView) {
            numberClicked = view.text.toString()
            sudokuBoard.addNumber(selectedPositionX, selectedPositionY, numberClicked!!.toInt())
            verifyIsValid()
        }
    }

    fun eraserClicked(view: View) {
        sudokuBoard.removeNumber(selectedPositionX, selectedPositionY)
        verifyIsValid()
    }
    private fun verifyIsValid(){
        text_game_is_valid.text = "Game is valid: "+sudokuGame.isValidGame()
    }

    override fun onPositionSelected(indexX: Int, indexY: Int) {
        selectedPositionX = indexX;
        selectedPositionY = indexY;

    }
}
