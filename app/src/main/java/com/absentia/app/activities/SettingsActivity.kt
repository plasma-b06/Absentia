package com.absentia.app.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.absentia.app.databinding.ActivitySettingsBinding
import com.absentia.app.utils.SessionManager
import com.absentia.app.utils.toast

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManager(this)

        binding.btnBack.setOnClickListener { finish() }

        binding.tvManageProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        binding.tvNeedHelp.setOnClickListener {
            toast("For support contact: support@absentia.app")
        }
        binding.tvAboutUs.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("About ABSENTIA")
                .setMessage("ABSENTIA v1.0\nSmart QR-based Attendance Management System\n\nBuilt for modern classrooms.\n\nDeveloped with ❤️ using Kotlin & Room DB")
                .setPositiveButton("OK", null).show()
        }
        binding.tvLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Logout") { _, _ ->
                    session.logout()
                    startActivity(Intent(this, LoginActivity::class.java)
                        .apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK })
                }
                .setNegativeButton("Cancel", null).show()
        }
    }
}
