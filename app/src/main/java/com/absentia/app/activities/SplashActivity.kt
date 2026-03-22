package com.absentia.app.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.absentia.app.R
import com.absentia.app.utils.SessionManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val session = SessionManager(this)
        Handler(Looper.getMainLooper()).postDelayed({
            if (session.isLoggedIn()) {
                val role = session.getUserRole()
                val intent = if (role == "TEACHER")
                    Intent(this, TeacherDashboardActivity::class.java)
                else
                    Intent(this, StudentDashboardActivity::class.java)
                startActivity(intent)
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 2000)
    }
}
