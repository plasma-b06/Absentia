package com.absentia.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val role: String,           // "STUDENT" or "TEACHER"
    val branch: String = "",
    val phoneNumber: String = "",
    val prnNumber: String = "", // For students
    val gender: String = "",
    val division: String = "",
    val year: String = "",
    val rollNo: String = "",
    val profileImagePath: String = ""
) : Parcelable
