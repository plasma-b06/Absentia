package com.absentia.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "class_enrollments")
data class ClassEnrollment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val studentId: Int,
    val classId: Int,
    val enrolledAt: Long = System.currentTimeMillis()
)
