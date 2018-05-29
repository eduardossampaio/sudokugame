package com.apps.esampaio.sudoku.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.apps.esampaio.sudoku.R
import com.apps.esampaio.sudoku.entity.extensions.asString
import com.apps.esampaio.sudoku.entity.Coordinate
import com.apps.esampaio.sudoku.entity.SudokuGame
import com.apps.esampaio.sudoku.entity.SudokuNumber
import com.apps.esampaio.sudoku.view.custom.SudokuBoardListener
import kotlinx.android.synthetic.main.activity_game.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*
import kotlinx.android.synthetic.main.activity_game.sudoku_board_view as sudokuBoard

class GameActivity : SuperActivity(), SudokuBoardListener {

    var numberClicked: String? = null
    var selectedPositionX: Int = -1
    var selectedPositionY: Int = -1
    var sudokuGame:SudokuGame = SudokuGame();

    var gameFinished:Boolean = false
    var activityRunning:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        sudokuBoard.listener = this
        this.sudokuGame = intent.extras["NUMBERS"] as SudokuGame
        sudokuBoard.sudokuGame = sudokuGame
        startCount()
    }

    private fun startCount() {
        doAsync {
            val initialTime = System.currentTimeMillis()
            var currentTime = initialTime
            while( ! gameFinished && activityRunning){
                Thread.sleep(1000)
                currentTime = System.currentTimeMillis()
//                val elapsedTime = Duration.of(currentTime, ChronoUnit.MILLIS)
                val timeAsText = Date(currentTime - initialTime).asString("mm:ss")
                uiThread {
                    time_text_view.text = timeAsText
                }
            }
        }
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
       if ( sudokuGame.isValidGame()){
           val intent = Intent(this,GameCompleteActivity::class.java)
           startActivity(intent)
       }
    }

    override fun onPositionSelected(indexX: Int, indexY: Int) {
        selectedPositionX = indexX;
        selectedPositionY = indexY;
    }
}
