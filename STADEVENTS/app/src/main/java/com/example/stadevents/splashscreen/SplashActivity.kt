package com.example.stadevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.stadevents.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent= Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}