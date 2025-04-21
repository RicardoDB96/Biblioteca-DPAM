package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.dpam.uanlbiblioteca.data.database.entity.BookLibraryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookWithLibraries
import kotlinx.coroutines.flow.Flow

@Dao
interface BookLibraryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookLibraryRelations(relations: List<BookLibraryEntity>)

    @Transaction
    @Query("SELECT * FROM BookEntity WHERE book_id = :bookId")
    suspend fun getBookWithLibrariesById(bookId: Long): BookWithLibraries?

    @Query("SELECT * FROM BookLibraryEntity WHERE book_id = :bookId")
    fun getBookLibraryById(bookId: Long): Flow<List<BookLibraryEntity>>
}
