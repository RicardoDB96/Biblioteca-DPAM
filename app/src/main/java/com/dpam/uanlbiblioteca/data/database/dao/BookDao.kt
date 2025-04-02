package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dpam.uanlbiblioteca.data.database.entity.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: List<BookEntity>)

    @Query("DELETE FROM BookEntity")
    suspend fun deleteAllBooks()

    @Query("SELECT * FROM BookEntity")
    fun getAllBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM BookEntity WHERE id = :bookId")
    suspend fun getBookById(bookId: Long): BookEntity?
}