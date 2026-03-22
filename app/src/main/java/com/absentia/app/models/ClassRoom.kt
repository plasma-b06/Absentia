package com.absentia.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "classes")
data class ClassRoom(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,           // e.g. "DBMS"
    val division: String,
    val teacherId: Int,
    val teacherName: String,
    val joinCode: String,       // unique 6-char code for students to join
    val branch: String = "",
    val year: String = ""
) : Parcelable
