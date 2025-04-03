package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dpam.uanlbiblioteca.data.database.entity.BookCategoryEntity

@Dao
interface BookCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookCategories(bookCategories: List<BookCategoryEntity>)

    @Query("SELECT * FROM BookCategoryEntity WHERE book_id = :bookId")
    suspend fun getCategoriesForBookById(bookId: Long): List<BookCategoryEntity>
}