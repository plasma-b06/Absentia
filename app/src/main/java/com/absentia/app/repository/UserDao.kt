package com.absentia.app.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.absentia.app.models.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    suspend fun login(email: String, password: String): User?

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM users WHERE role = 'STUDENT'")
    fun getAllStudents(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE role = 'TEACHER'")
    fun getAllTeachers(): LiveData<List<User>>

    @Query("SELECT COUNT(*) FROM users WHERE email = :email")
    suspend fun emailExists(email: String): Int

    @Query("UPDATE users SET password = :newPassword WHERE id = :userId")
    suspend fun updatePassword(userId: Int, newPassword: String)
}
