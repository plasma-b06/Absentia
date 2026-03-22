package com.absentia.app.viewmodels

import android.app.Application
import android.graphics.Bitmap
import androidx.lifecycle.*
import com.absentia.app.AbsentiaApp
import com.absentia.app.models.AttendanceRecord
import com.absentia.app.models.AttendanceSession
import com.absentia.app.repository.AbsentiaRepository
import com.absentia.app.utils.QRHelper
import com.absentia.app.utils.getCurrentDate
import kotlinx.coroutines.launch

sealed class AttendanceState {
    object Idle : AttendanceState()
    object Loading : AttendanceState()
    data class SessionCreated(val session: AttendanceSession, val qrBitmap: Bitmap) : AttendanceState()
    data class MarkedSuccess(val message: String) : AttendanceState()
    data class Error(val message: String) : AttendanceState()
}

class AttendanceViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: AbsentiaRepository = (application as AbsentiaApp).repository

    private val _state = MutableLiveData<AttendanceState>(AttendanceState.Idle)
    val state: LiveData<AttendanceState> = _state

    private var _activeSession: AttendanceSession? = null
    val activeSession get() = _activeSession

    fun getTeacherSessions(teacherId: Int) = repo.getTeacherSessions(teacherId)
    fun getStudentAttendance(studentId: Int) = repo.getStudentAttendance(studentId)
    fun getSessionAttendance(sessionId: Int) = repo.getSessionAttendance(sessionId)

    fun createSession(classId: Int, className: String, teacherId: Int, timeSlot: String, subject: String) {
        if (timeSlot.isBlank() || subject.isBlank()) {
            _state.value = AttendanceState.Error("Please fill all fields")
            return
        }
        _state.value = AttendanceState.Loading
        viewModelScope.launch {
            val token = QRHelper.generateToken()
            val session = AttendanceSession(
                classId = classId,
                className = className,
                teacherId = teacherId,
                date = getCurrentDate(),
                timeSlot = timeSlot,
                subject = subject,
                qrToken = token
            )
            val id = repo.createSession(session)
            val saved = repo.getSessionById(id.toInt())
            if (saved != null) {
                _activeSession = saved
                val bitmap = QRHelper.generateQRBitmap(token)
                if (bitmap != null) {
                    _state.value = AttendanceState.SessionCreated(saved, bitmap)
                } else {
                    _state.value = AttendanceState.Error("Failed to generate QR code")
                }
            } else {
                _state.value = AttendanceState.Error("Failed to create session")
            }
        }
    }

    fun endSession(sessionId: Int) {
        viewModelScope.launch {
            repo.endSession(sessionId)
            _activeSession = null
            _state.value = AttendanceState.Idle
        }
    }

    fun scanAndMarkAttendance(qrContent: String, student: com.absentia.app.models.User) {
        _state.value = AttendanceState.Loading
        viewModelScope.launch {
            val session = repo.getSessionByToken(qrContent)
            if (session == null) {
                _state.value = AttendanceState.Error("Invalid or expired QR code")
                return@launch
            }
            if (repo.alreadyMarked(session.id, student.id)) {
                _state.value = AttendanceState.Error("Attendance already marked for this session")
                return@launch
            }
            val record = AttendanceRecord(
                sessionId = session.id,
                studentId = student.id,
                studentName = "${student.firstName} ${student.lastName}",
                classId = session.classId,
                subject = session.subject,
                date = session.date,
                timeSlot = session.timeSlot
            )
            repo.markAttendance(record)
            _state.value = AttendanceState.MarkedSuccess("✓ Attendance marked for ${session.subject} — ${session.date}")
        }
    }

    suspend fun getAttendancePercentage(studentId: Int, classId: Int): Float =
        repo.getAttendancePercentage(studentId, classId)

    fun resetState() { _state.value = AttendanceState.Idle }
}
