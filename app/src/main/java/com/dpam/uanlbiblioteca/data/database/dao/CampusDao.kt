package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dpam.uanlbiblioteca.data.database.entity.CampusEntity

@Dao
interface CampusDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCampuses(campuses: List<CampusEntity>)

    @Query("SELECT * FROM CampusEntity")
    suspend fun getAllCampuses(): List<CampusEntity>

    @Query("SELECT * FROM CampusEntity WHERE name = :campusName")
    suspend fun getCampusIdByName(campusName: String): CampusEntity?
}