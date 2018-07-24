package com.apps.esampaio.sudoku.entity


import java.io.Serializable
import java.util.*

/**
 * Created by eduar on 02/04/2018.
 */

class SudokuGame : Serializable{
    var sudokuNumbers: MutableList<SudokuNumber> = mutableListOf()
    var gameName:String
    var isCompleted:Boolean = false
    var difficulity:String=""


    constructor(){
        gameName = "No Name"
    }
    constructor(name:String,sudokuNumbers: MutableList<SudokuNumber>) {
        this.sudokuNumbers = sudokuNumbers;
        this.gameName = name;
    }
    constructor(name:String,sudokuNumbers: MutableList<SudokuNumber>,difficulity:String) {
        this.sudokuNumbers = sudokuNumbers;
        this.gameName = name;
        this.difficulity = difficulity
    }

    fun addNumber(indexX: Int, indexY: Int, number: Int):Boolean {

        if (indexX in 0..8 && indexY in 0..8) {
            val position = Coordinate(indexX,indexY)
            val numberFound = getNumber(position)
            if(numberFound != null){
                if(!numberFound.immutable){
                    sudokuNumbers.add( SudokuNumber(position,number, false))
                    return true
                }
            }else{
                sudokuNumbers.add( SudokuNumber(position,number, false))
                    return true
            }
            return false
        }
        return false
    }
    fun removeNumber(indexX: Int, indexY: Int):Boolean {
        val number = getNumber(indexX,indexY)
        if(number != null){
            sudokuNumbers.remove(number)
            return true
        }
        return false
    }

    private fun getNumber(indexX: Int,indexY: Int): SudokuNumber?{
        return getNumber(Coordinate(indexX,indexY))
    }
    private fun getNumber(coordinate: Coordinate): SudokuNumber?{
        for (number in sudokuNumbers){
            if(number.coordinate.equals(coordinate)){
                return number
            }
        }
        return null
    }
    fun isValidGame(): Boolean {
        return allNumbersIsSet() && allRowsIsValid() && allColumnsIsValid() && allQuadrantsIsValid()
    }

    private fun allNumbersIsSet(): Boolean {
        return sudokuNumbers.size == 81;
    }

    private fun allRowsIsValid(): Boolean {
        for (i in 0..8) {
            if (!isRowValid(i)) {
                return false;
            }
        }
        return true;
    }

    private fun allColumnsIsValid(): Boolean {
        for (i in 0..8) {
            if (!isColumnValid(i)) {
                return false;
            }
        }
        return true;
    }

    private fun allQuadrantsIsValid(): Boolean {
        for (x in 0..6 step 3) {
            for (y in 0..6 step 3) {
                if (!isQuadrantValid(Coordinate(x, y))) {
                    return false
                }
            }
        }
        return true
    }

    private fun isColumnValid(columnIndex: Int): Boolean {
        for (number in 1..9) {
            var containsNumber = false;
            for (rowIndex in 0..8) {
                val sudokuNumber =  getNumber(columnIndex, rowIndex)
                        //sudokuNumbers[Coordinate(columnIndex, rowIndex)]
                if (sudokuNumber?.value == number) {
                    containsNumber = true;
                }
            }
            if (!containsNumber) {
                return false
            }
        }
        return true;
    }

    private fun isRowValid(rowIndex: Int): Boolean {
        for (number in 1..9) {
            var containsNumber = false;
            for (columnIndex in 0..8) {
                val sudokuNumber = getNumber(columnIndex, rowIndex)
                        //sudokuNumbers[Coordinate(columnIndex, rowIndex)]
                if (sudokuNumber?.value == number) {
                    containsNumber = true;
                }
            }
            if (!containsNumber) {
                return false
            }
        }
        return true;
    }

    private fun isQuadrantValid(initialPosition: Coordinate): Boolean {

        for (number in 1..9) {
            var containsNumber = false;
            for (i in initialPosition.y..initialPosition.y + 2) {
                for (j in initialPosition.x..initialPosition.x + 2) {
                    val sudokuNumber = getNumber(i, j)
                    //sudokuNumbers[Coordinate(i, j)]
                    if(sudokuNumber?.value==number){
                        containsNumber = true
                    }
                }
            }
            if(!containsNumber){
                return false
            }
        }
        return true;
    }



}
