package com.apps.esampaio.sudoku.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.DecelerateInterpolator
import com.apps.esampaio.sudoku.R
import com.apps.esampaio.sudoku.entity.extensions.asString
import kotlinx.android.synthetic.main.activity_game_complete.*
import java.util.*

class GameCompleteActivity : AppCompatActivity() {

    companion object {
        val EXTRAS_DIFICULITY = "EXTRAS_DIFICULITY"
        val EXTRAS_SPENDED_TIME = "EXTRAS_SPENDED_TIME"
        val EXTRAS_LEVEL_NUMBER = "LEVEL_NUMBER"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_complete)

        if ( intent.extras!= null) {
            val difficulity = intent.extras.getString(EXTRAS_DIFICULITY)
            val spendTime = intent.extras.getLong(EXTRAS_SPENDED_TIME)
            val levelNumber = intent.extras.getString(EXTRAS_LEVEL_NUMBER)

            if (levelNumber != null) {
                statistics_level.text = levelNumber
            }
            if (difficulity != null) {
                statistics_difficulity.text = difficulity
            }
            if (spendTime != null) {
                statistics_time.text = Date(spendTime).asString("mm:ss")
            }
        }

        visibleWithFadeIn(statistics_row_level,1000)
        visibleWithFadeIn(statistics_row_difficulity,2000)
        visibleWithFadeIn(statistics_row_time,3000)

    }

    private fun visibleWithFadeIn(view:View, duration:Long){
        val fadeInAnimattion = AlphaAnimation(0f,1f)
        fadeInAnimattion.duration = duration
        fadeInAnimattion.interpolator = DecelerateInterpolator()
        view.animation = fadeInAnimattion
        view.visibility = View.VISIBLE
    }

    fun  buttonShareClick(view: View){

    }
    fun  buttonCloseClick(view: View){
        finish()
    }

}