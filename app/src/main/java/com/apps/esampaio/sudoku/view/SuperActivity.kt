package com.apps.esampaio.sudoku.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper



/**
 * Created by eduar on 04/04/2018.
 */

open class SuperActivity:AppCompatActivity(){
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}
