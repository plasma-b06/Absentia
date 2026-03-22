package com.absentia.app.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.absentia.app.models.*

class AbsentiaRepository(context: Context) {
    private val db = AbsentiaDatabase.getDatabase(context)
    private val userDao = db.userDao()
    private val classDao = db.classDao()
    private val attendanceDao = db.attendanceDao()

    // ─── User ───────────────────────────────────────────────
    suspend fun registerUser(user: User): Long = userDao.insertUser(user)
    suspend fun login(email: String, password: String): User? = userDao.login(email, password)
    suspend fun getUserById(id: Int): User? = userDao.getUserById(id)
    suspend fun emailExists(email: String): Boolean = userDao.emailExists(email) > 0
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    suspend fun updatePassword(userId: Int, newPassword: String) = userDao.updatePassword(userId, newPassword)

    // ─── Class ──────────────────────────────────────────────
    suspend fun createClass(classRoom: ClassRoom): Long = classDao.insertClass(classRoom)
    fun getTeacherClasses(teacherId: Int): LiveData<List<ClassRoom>> = classDao.getClassesByTeacher(teacherId)
    fun getStudentClasses(studentId: Int): LiveData<List<ClassRoom>> = classDao.getEnrolledClasses(studentId)
    suspend fun getClassByCode(code: String): ClassRoom? = classDao.getClassByJoinCode(code)
    suspend fun getClassById(id: Int): ClassRoom? = classDao.getClassById(id)
    suspend fun joinClass(enrollment: ClassEnrollment): Long = classDao.enrollStudent(enrollment)
    suspend fun isEnrolled(studentId: Int, classId: Int): Boolean = classDao.isEnrolled(studentId, classId) > 0
    suspend fun getStudentCount(classId: Int): Int = classDao.getStudentCount(classId)
    suspend fun deleteClass(classRoom: ClassRoom) = classDao.deleteClass(classRoom)

    // ─── Attendance ─────────────────────────────────────────
    suspend fun createSession(session: AttendanceSession): Long = attendanceDao.insertSession(session)
    suspend fun endSession(sessionId: Int) = attendanceDao.endSession(sessionId)
    suspend fun getSessionByToken(token: String): AttendanceSession? = attendanceDao.getActiveSessionByToken(token)
    suspend fun getSessionById(id: Int): AttendanceSession? = attendanceDao.getSessionById(id)
    fun getTeacherSessions(teacherId: Int): LiveData<List<AttendanceSession>> = attendanceDao.getSessionsByTeacher(teacherId)
    fun getClassSessions(classId: Int): LiveData<List<AttendanceSession>> = attendanceDao.getSessionsByClass(classId)
    suspend fun markAttendance(record: AttendanceRecord): Long = attendanceDao.insertRecord(record)
    suspend fun alreadyMarked(sessionId: Int, studentId: Int): Boolean = attendanceDao.alreadyMarked(sessionId, studentId) > 0
    fun getStudentAttendance(studentId: Int): LiveData<List<AttendanceRecord>> = attendanceDao.getRecordsByStudent(studentId)
    fun getSessionAttendance(sessionId: Int): LiveData<List<AttendanceRecord>> = attendanceDao.getRecordsBySession(sessionId)
    suspend fun getAttendancePercentage(studentId: Int, classId: Int): Float {
        val present = attendanceDao.getPresentCount(studentId, classId)
        val total = attendanceDao.getTotalSessions(classId)
        return if (total == 0) 0f else (present.toFloat() / total.toFloat()) * 100f
    }
}
