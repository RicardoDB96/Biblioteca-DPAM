package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.dpam.uanlbiblioteca.data.database.entity.StudentEntity
import com.dpam.uanlbiblioteca.data.database.entity.StudentWithDetails

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: StudentEntity): Long

    @Query("DELETE FROM StudentEntity")
    suspend fun deleteAllStudents()

    @Transaction
    @Query("SELECT * FROM StudentEntity LIMIT 1")
    suspend fun getStudentWithDetails(): StudentWithDetails?
}