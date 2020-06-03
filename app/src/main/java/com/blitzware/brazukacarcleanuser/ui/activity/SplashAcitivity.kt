package com.blitzware.brazukacarcleanuser.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.blitzware.brazukacarcleanuser.R

class SplashAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_acitivity)
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
        }, 1500)
    }
}