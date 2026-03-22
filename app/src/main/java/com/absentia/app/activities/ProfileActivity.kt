package com.absentia.app.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.absentia.app.AbsentiaApp
import com.absentia.app.databinding.ActivityProfileBinding
import com.absentia.app.utils.SessionManager
import com.absentia.app.utils.toast
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManager(this)

        binding.btnBack.setOnClickListener { finish() }

        loadProfile()
        setupActions()
    }

    private fun loadProfile() {
        val repo = (application as AbsentiaApp).repository
        lifecycleScope.launch {
            val user = repo.getUserById(session.getUserId())
            user?.let {
                binding.tvName.text = "${it.firstName} ${it.lastName}"
                binding.etEmail.setText(it.email)
                binding.etPhone.setText(it.phoneNumber)
                binding.etBranch.setText(it.branch)
                if (it.role == "STUDENT") {
                    binding.etPrn.setText(it.prnNumber)
                    binding.tvRole.text = "Student | ${it.division} | Year ${it.year}"
                } else {
                    binding.tvRole.text = "Teacher"
                }
            }
        }
    }

    private fun setupActions() {
        binding.btnChangePassword.setOnClickListener {
            val old = binding.etOldPassword.text.toString()
            val newPass = binding.etNewPassword.text.toString()
            if (old.isBlank() || newPass.isBlank()) { toast("Fill in both password fields"); return@setOnClickListener }
            if (newPass.length < 6) { toast("New password must be at least 6 characters"); return@setOnClickListener }
            val repo = (application as AbsentiaApp).repository
            lifecycleScope.launch {
                val user = repo.getUserById(session.getUserId())
                if (user?.password == old) {
                    repo.updatePassword(session.getUserId(), newPass)
                    toast("Password updated successfully")
                    binding.etOldPassword.text?.clear()
                    binding.etNewPassword.text?.clear()
                } else {
                    toast("Current password is incorrect")
                }
            }
        }
    }
}
