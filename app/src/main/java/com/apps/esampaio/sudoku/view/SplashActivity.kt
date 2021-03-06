package com.apps.esampaio.sudoku.view


import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.apps.esampaio.sudoku.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : SuperActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Timer().schedule(2000, {
            goToMainActivity();
        })
    }

    private fun goToMainActivity() {
        runOnUiThread {
//            val options = ActivityOptions.makeSceneTransitionAnimation(this@SplashActivity, logo, "logo_transition")
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
