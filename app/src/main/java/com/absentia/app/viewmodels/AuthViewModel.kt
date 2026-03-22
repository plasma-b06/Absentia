package com.absentia.app.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.absentia.app.AbsentiaApp
import com.absentia.app.models.User
import com.absentia.app.repository.AbsentiaRepository
import kotlinx.coroutines.launch

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val user: User) : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: AbsentiaRepository = (application as AbsentiaApp).repository

    private val _authState = MutableLiveData<AuthState>(AuthState.Idle)
    val authState: LiveData<AuthState> = _authState

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _authState.value = AuthState.Error("Please fill all fields")
            return
        }
        _authState.value = AuthState.Loading
        viewModelScope.launch {
            val user = repo.login(email.trim(), password)
            if (user != null) _authState.value = AuthState.Success(user)
            else _authState.value = AuthState.Error("Invalid email or password")
        }
    }

    fun register(user: User) {
        _authState.value = AuthState.Loading
        viewModelScope.launch {
            if (repo.emailExists(user.email)) {
                _authState.value = AuthState.Error("Email already registered")
                return@launch
            }
            val id = repo.registerUser(user)
            val saved = repo.getUserById(id.toInt())
            if (saved != null) _authState.value = AuthState.Success(saved)
            else _authState.value = AuthState.Error("Registration failed, please retry")
        }
    }

    fun resetState() { _authState.value = AuthState.Idle }
}
