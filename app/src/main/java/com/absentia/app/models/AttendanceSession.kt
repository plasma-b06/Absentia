package com.absentia.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "attendance_sessions")
data class AttendanceSession(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val classId: Int,
    val className: String,
    val teacherId: Int,
    val date: String,           // "DD MMM YYYY"
    val timeSlot: String,       // "9:40 - 10:30"
    val subject: String,
    val qrToken: String,        // unique token encoded in QR
    val isActive: Boolean = true,
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable
