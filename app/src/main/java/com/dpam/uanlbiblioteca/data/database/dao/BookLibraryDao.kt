package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.dpam.uanlbiblioteca.data.database.entity.BookLibraryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookWithLibraries

@Dao
interface BookLibraryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookLibraryRelations(relations: List<BookLibraryEntity>)

    @Query("DELETE FROM BookLibraryEntity")
    suspend fun deleteAllBookLibraryRelations()

    @Transaction
    @Query("SELECT * FROM BookEntity WHERE id = :bookId")
    suspend fun getBookWithLibrariesById(bookId: Long): BookWithLibraries?

}
