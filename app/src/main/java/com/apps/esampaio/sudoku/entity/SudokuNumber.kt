package com.apps.esampaio.sudoku.entity

import java.io.Serializable

/**
 * Created by eduar on 01/04/2018.
 */

data class SudokuNumber(var coordinate: Coordinate,var value: Int, var immutable:Boolean=true):Serializable {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is SudokuNumber) {
            return false
        }
        val otherSudokuNumber = other
        return otherSudokuNumber.value == this.value
    }
}
