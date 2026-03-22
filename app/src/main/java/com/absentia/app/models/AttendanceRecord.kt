package com.absentia.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "attendance_records")
data class AttendanceRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val sessionId: Int,
    val studentId: Int,
    val studentName: String,
    val classId: Int,
    val subject: String,
    val date: String,
    val timeSlot: String,
    val markedAt: Long = System.currentTimeMillis(),
    val status: String = "PRESENT"  // PRESENT / ABSENT
)
