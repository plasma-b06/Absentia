package com.absentia.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.absentia.app.databinding.ActivityRegisterBinding
import com.absentia.app.models.User
import com.absentia.app.utils.*
import com.absentia.app.viewmodels.AuthState
import com.absentia.app.viewmodels.AuthViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: AuthViewModel by viewModels()
    private var selectedRole = "STUDENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRoleToggle()
        setupObserver()

        binding.btnBack.setOnClickListener { finish() }

        binding.btnSave.setOnClickListener { validateAndRegister() }
    }

    private fun setupRoleToggle() {
        binding.btnStudent.setOnClickListener {
            selectedRole = "STUDENT"
            binding.btnStudent.isSelected = true
            binding.btnTeacher.isSelected = false
            binding.layoutStudentFields.visible()
        }
        binding.btnTeacher.setOnClickListener {
            selectedRole = "TEACHER"
            binding.btnTeacher.isSelected = true
            binding.btnStudent.isSelected = false
            binding.layoutStudentFields.gone()
        }
        binding.btnStudent.isSelected = true
        binding.layoutStudentFields.visible()
    }

    private fun validateAndRegister() {
        val firstName = binding.etFirstName.text.toString().trim()
        val lastName = binding.etLastName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString()
        val branch = binding.etBranch.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()

        when {
            firstName.isBlank() || lastName.isBlank() -> { toast("Enter your full name"); return }
            !email.isValidEmail() -> { toast("Enter a valid email"); return }
            !password.isValidPassword() -> { toast("Password must be at least 6 characters"); return }
        }

        val prn = if (selectedRole == "STUDENT") binding.etPrn.text.toString().trim() else ""
        val gender = if (selectedRole == "STUDENT") binding.spinnerGender.selectedItem.toString() else ""
        val division = if (selectedRole == "STUDENT") binding.etDivision.text.toString().trim() else ""
        val year = if (selectedRole == "STUDENT") binding.spinnerYear.selectedItem.toString() else ""
        val rollNo = if (selectedRole == "STUDENT") binding.etRollNo.text.toString().trim() else ""

        val user = User(
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password,
            role = selectedRole,
            branch = branch,
            phoneNumber = phone,
            prnNumber = prn,
            gender = gender,
            division = division,
            year = year,
            rollNo = rollNo
        )
        viewModel.register(user)
    }

    private fun setupObserver() {
        viewModel.authState.observe(this) { state ->
            when (state) {
                is AuthState.Loading -> {
                    binding.progressBar.visible()
                    binding.btnSave.isEnabled = false
                }
                is AuthState.Success -> {
                    binding.progressBar.gone()
                    toast("Registration successful! Please login.")
                    startActivity(Intent(this, LoginActivity::class.java)
                        .apply { flags = Intent.FLAG_ACTIVITY_CLEAR_TOP })
                    finish()
                }
                is AuthState.Error -> {
                    binding.progressBar.gone()
                    binding.btnSave.isEnabled = true
                    toast(state.message)
                    viewModel.resetState()
                }
                else -> {
                    binding.progressBar.gone()
                    binding.btnSave.isEnabled = true
                }
            }
        }
    }
}
