package com.absentia.app.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("absentia_session", Context.MODE_PRIVATE)

    companion object {
        const val KEY_USER_ID = "user_id"
        const val KEY_USER_ROLE = "user_role"
        const val KEY_USER_NAME = "user_name"
        const val KEY_USER_EMAIL = "user_email"
        const val KEY_IS_LOGGED_IN = "is_logged_in"
    }

    fun saveSession(userId: Int, role: String, name: String, email: String) {
        prefs.edit().apply {
            putInt(KEY_USER_ID, userId)
            putString(KEY_USER_ROLE, role)
            putString(KEY_USER_NAME, name)
            putString(KEY_USER_EMAIL, email)
            putBoolean(KEY_IS_LOGGED_IN, true)
            apply()
        }
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    fun getUserId(): Int = prefs.getInt(KEY_USER_ID, -1)
    fun getUserRole(): String = prefs.getString(KEY_USER_ROLE, "") ?: ""
    fun getUserName(): String = prefs.getString(KEY_USER_NAME, "") ?: ""
    fun getUserEmail(): String = prefs.getString(KEY_USER_EMAIL, "") ?: ""

    fun logout() {
        prefs.edit().clear().apply()
    }
}
