package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity

@Dao
interface LibraryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLibraries(libraries: List<LibraryEntity>)

    @Query("DELETE FROM LibraryEntity")
    suspend fun deleteAllLibraries()

    @Query("SELECT * FROM LibraryEntity")
    suspend fun getAllLibraries(): List<LibraryEntity>

    @Query("SELECT * FROM LibraryEntity WHERE id = :libraryId")
    suspend fun getLibraryById(libraryId: Long): LibraryEntity?
}
