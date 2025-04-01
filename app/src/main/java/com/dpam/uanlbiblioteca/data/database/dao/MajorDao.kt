package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dpam.uanlbiblioteca.data.database.entity.MajorEntity

@Dao
interface MajorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMajors(majors: List<MajorEntity>)

    @Query("SELECT * FROM MajorEntity")
    suspend fun getAllMajors(): List<MajorEntity>

    @Query("SELECT * FROM MajorEntity WHERE name = :majorName")
    suspend fun getMajorIdByName(majorName: String): MajorEntity?
}