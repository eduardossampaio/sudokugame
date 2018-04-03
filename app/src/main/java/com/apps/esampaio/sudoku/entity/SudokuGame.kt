package com.apps.esampaio.sudoku.entity

import android.graphics.Point
import android.util.Log
import java.text.FieldPosition
import java.util.HashMap

/**
 * Created by eduar on 02/04/2018.
 */

class SudokuGame {
    var sudokuNumbers: HashMap<Point, SudokuNumber> = HashMap();

    constructor() {
    }

    constructor(sudokuNumbers: HashMap<Point, SudokuNumber>) {
        this.sudokuNumbers = sudokuNumbers;
    }

    fun addNumber(indexX: Int, indexY: Int, number: Int) {
        if (indexX in 0..8 && indexY in 0..8) {
            val position = Point(indexX, indexY)
            if (sudokuNumbers.containsKey(position)) {
                val numberSelected = sudokuNumbers[position]
                if (!numberSelected!!.immutable) {
                    sudokuNumbers.put(position, SudokuNumber(number, false))

                }

            } else {
                sudokuNumbers.put(position, SudokuNumber(number, false))
            }
        }
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
                if (!isQuadrantValid(Point(x, y))) {
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
                val sudokuNumber = sudokuNumbers[Point(columnIndex, rowIndex)]
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
                val sudokuNumber = sudokuNumbers[Point(columnIndex, rowIndex)]
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

    private fun isQuadrantValid(initialPosition: Point): Boolean {

        for (number in 1..9) {
            var containsNumber = false;
            for (i in initialPosition.y..initialPosition.y + 2) {
                for (j in initialPosition.x..initialPosition.x + 2) {
                    val sudokuNumber = sudokuNumbers[Point(i, j)]
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
