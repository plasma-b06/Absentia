package com.absentia.app.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.absentia.app.models.*

@Database(
    entities = [
        User::class,
        ClassRoom::class,
        ClassEnrollment::class,
        AttendanceSession::class,
        AttendanceRecord::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AbsentiaDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun classDao(): ClassDao
    abstract fun attendanceDao(): AttendanceDao

    companion object {
        @Volatile
        private var INSTANCE: AbsentiaDatabase? = null

        fun getDatabase(context: Context): AbsentiaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AbsentiaDatabase::class.java,
                    "absentia_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
