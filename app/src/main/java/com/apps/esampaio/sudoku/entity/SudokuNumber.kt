package com.apps.esampaio.sudoku.entity

import java.io.Serializable

/**
 * Created by eduar on 01/04/2018.
 */

data class SudokuNumber(var value: Int, var immutable:Boolean=true):Serializable {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is SudokuNumber) {
            return false
        }
        val otherSudokuNumber = other as SudokuNumber
        return otherSudokuNumber.value == this.value
    }
}
