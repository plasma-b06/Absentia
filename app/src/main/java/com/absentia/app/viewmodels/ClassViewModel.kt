package com.absentia.app.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.absentia.app.AbsentiaApp
import com.absentia.app.models.ClassEnrollment
import com.absentia.app.models.ClassRoom
import com.absentia.app.repository.AbsentiaRepository
import com.absentia.app.utils.generateJoinCode
import kotlinx.coroutines.launch

sealed class ClassState {
    object Idle : ClassState()
    object Loading : ClassState()
    data class Success(val message: String) : ClassState()
    data class Error(val message: String) : ClassState()
    data class ClassDetail(val classRoom: ClassRoom) : ClassState()
}

class ClassViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: AbsentiaRepository = (application as AbsentiaApp).repository

    private val _classState = MutableLiveData<ClassState>(ClassState.Idle)
    val classState: LiveData<ClassState> = _classState

    fun getTeacherClasses(teacherId: Int) = repo.getTeacherClasses(teacherId)
    fun getStudentClasses(studentId: Int) = repo.getStudentClasses(studentId)

    fun createClass(name: String, division: String, teacherId: Int, teacherName: String, branch: String, year: String) {
        if (name.isBlank() || division.isBlank()) {
            _classState.value = ClassState.Error("Please fill all fields")
            return
        }
        _classState.value = ClassState.Loading
        viewModelScope.launch {
            val classRoom = ClassRoom(
                name = name.trim(),
                division = division.trim(),
                teacherId = teacherId,
                teacherName = teacherName,
                joinCode = generateJoinCode(),
                branch = branch,
                year = year
            )
            repo.createClass(classRoom)
            _classState.value = ClassState.Success("Class '${name}' created successfully!")
        }
    }

    fun joinClass(code: String, studentId: Int) {
        if (code.isBlank()) {
            _classState.value = ClassState.Error("Enter a valid join code")
            return
        }
        _classState.value = ClassState.Loading
        viewModelScope.launch {
            val classRoom = repo.getClassByCode(code.trim().uppercase())
            if (classRoom == null) {
                _classState.value = ClassState.Error("Class not found. Check the code and try again")
                return@launch
            }
            if (repo.isEnrolled(studentId, classRoom.id)) {
                _classState.value = ClassState.Error("You are already enrolled in '${classRoom.name}'")
                return@launch
            }
            repo.joinClass(ClassEnrollment(studentId = studentId, classId = classRoom.id))
            _classState.value = ClassState.Success("Joined '${classRoom.name}' successfully!")
        }
    }

    fun deleteClass(classRoom: ClassRoom) {
        viewModelScope.launch { repo.deleteClass(classRoom) }
    }

    fun resetState() { _classState.value = ClassState.Idle }
}
