package com.absentia.app.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.absentia.app.models.ClassEnrollment
import com.absentia.app.models.ClassRoom

@Dao
interface ClassDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClass(classRoom: ClassRoom): Long

    @Update
    suspend fun updateClass(classRoom: ClassRoom)

    @Delete
    suspend fun deleteClass(classRoom: ClassRoom)

    @Query("SELECT * FROM classes WHERE teacherId = :teacherId ORDER BY name ASC")
    fun getClassesByTeacher(teacherId: Int): LiveData<List<ClassRoom>>

    @Query("SELECT * FROM classes WHERE id = :classId LIMIT 1")
    suspend fun getClassById(classId: Int): ClassRoom?

    @Query("SELECT * FROM classes WHERE joinCode = :code LIMIT 1")
    suspend fun getClassByJoinCode(code: String): ClassRoom?

    // Get classes a student is enrolled in
    @Query("""
        SELECT c.* FROM classes c 
        INNER JOIN class_enrollments e ON c.id = e.classId 
        WHERE e.studentId = :studentId
        ORDER BY c.name ASC
    """)
    fun getEnrolledClasses(studentId: Int): LiveData<List<ClassRoom>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun enrollStudent(enrollment: ClassEnrollment): Long

    @Query("SELECT COUNT(*) FROM class_enrollments WHERE studentId = :studentId AND classId = :classId")
    suspend fun isEnrolled(studentId: Int, classId: Int): Int

    @Query("SELECT COUNT(*) FROM class_enrollments WHERE classId = :classId")
    suspend fun getStudentCount(classId: Int): Int
}
