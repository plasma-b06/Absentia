package com.absentia.app.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.absentia.app.databinding.ActivityLoginBinding
import com.absentia.app.utils.SessionManager
import com.absentia.app.utils.toast
import com.absentia.app.utils.visible
import com.absentia.app.utils.gone
import com.absentia.app.viewmodels.AuthState
import com.absentia.app.viewmodels.AuthViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: AuthViewModel by viewModels()
    private lateinit var session: SessionManager
    private var selectedRole = "STUDENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManager(this)

        setupRoleToggle()
        setupObserver()

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()
            viewModel.login(email, password)
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.tvForgotPassword.setOnClickListener {
            toast("Please contact your administrator to reset your password")
        }
    }

    private fun setupRoleToggle() {
        binding.btnStudent.setOnClickListener {
            selectedRole = "STUDENT"
            binding.btnStudent.isSelected = true
            binding.btnTeacher.isSelected = false
        }
        binding.btnTeacher.setOnClickListener {
            selectedRole = "TEACHER"
            binding.btnTeacher.isSelected = true
            binding.btnStudent.isSelected = false
        }
        binding.btnStudent.isSelected = true
    }

    private fun setupObserver() {
        viewModel.authState.observe(this) { state ->
            when (state) {
                is AuthState.Loading -> {
                    binding.progressBar.visible()
                    binding.btnLogin.isEnabled = false
                }
                is AuthState.Success -> {
                    binding.progressBar.gone()
                    binding.btnLogin.isEnabled = true
                    val user = state.user
                    if (user.role != selectedRole) {
                        toast("This account is not a ${selectedRole.lowercase()} account")
                        viewModel.resetState()
                        return@observe
                    }
                    session.saveSession(user.id, user.role, "${user.firstName} ${user.lastName}", user.email)
                    val intent = if (user.role == "TEACHER")
                        Intent(this, TeacherDashboardActivity::class.java)
                    else
                        Intent(this, StudentDashboardActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                is AuthState.Error -> {
                    binding.progressBar.gone()
                    binding.btnLogin.isEnabled = true
                    toast(state.message)
                    viewModel.resetState()
                }
                else -> {
                    binding.progressBar.gone()
                    binding.btnLogin.isEnabled = true
                }
            }
        }
    }
}
