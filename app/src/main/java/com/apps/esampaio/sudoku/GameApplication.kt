package com.apps.esampaio.sudoku

import android.app.Application
import uk.co.chrisjenx.calligraphy.CalligraphyConfig



/**
 * Created by eduar on 04/04/2018.
 */

class GameApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/comic_sans_ms_bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }
}
