package com.absentia.app.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.absentia.app.models.AttendanceRecord
import com.absentia.app.models.AttendanceSession

@Dao
interface AttendanceDao {

    // Sessions
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: AttendanceSession): Long

    @Query("UPDATE attendance_sessions SET isActive = 0 WHERE id = :sessionId")
    suspend fun endSession(sessionId: Int)

    @Query("SELECT * FROM attendance_sessions WHERE id = :sessionId LIMIT 1")
    suspend fun getSessionById(sessionId: Int): AttendanceSession?

    @Query("SELECT * FROM attendance_sessions WHERE qrToken = :token AND isActive = 1 LIMIT 1")
    suspend fun getActiveSessionByToken(token: String): AttendanceSession?

    @Query("SELECT * FROM attendance_sessions WHERE teacherId = :teacherId ORDER BY createdAt DESC")
    fun getSessionsByTeacher(teacherId: Int): LiveData<List<AttendanceSession>>

    @Query("SELECT * FROM attendance_sessions WHERE classId = :classId ORDER BY createdAt DESC")
    fun getSessionsByClass(classId: Int): LiveData<List<AttendanceSession>>

    // Records
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecord(record: AttendanceRecord): Long

    @Query("SELECT COUNT(*) FROM attendance_records WHERE sessionId = :sessionId AND studentId = :studentId")
    suspend fun alreadyMarked(sessionId: Int, studentId: Int): Int

    @Query("SELECT * FROM attendance_records WHERE studentId = :studentId ORDER BY markedAt DESC")
    fun getRecordsByStudent(studentId: Int): LiveData<List<AttendanceRecord>>

    @Query("SELECT * FROM attendance_records WHERE sessionId = :sessionId ORDER BY studentName ASC")
    fun getRecordsBySession(sessionId: Int): LiveData<List<AttendanceRecord>>

    @Query("SELECT COUNT(*) FROM attendance_records WHERE studentId = :studentId AND classId = :classId AND status = 'PRESENT'")
    suspend fun getPresentCount(studentId: Int, classId: Int): Int

    @Query("SELECT COUNT(DISTINCT sessionId) FROM attendance_records WHERE classId = :classId")
    suspend fun getTotalSessions(classId: Int): Int
}
