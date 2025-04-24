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

    @Query("UPDATE BookLibraryEntity SET quantity = quantity - 1 WHERE book_id = :bookId AND library_id = :libraryId AND quantity > 0")
    suspend fun decrementQuantity(bookId: Long, libraryId: Long)

    @Query("""
        SELECT library_id
        FROM BookLibraryEntity
        WHERE book_id = :bookId
        ORDER BY RANDOM()
        LIMIT 1
    """)
    suspend fun getRandomLibraryId(bookId: Long): Long?

    @Query("""
        UPDATE BookLibraryEntity
        SET quantity = quantity + 1
        WHERE book_id = :bookId AND library_id = :libraryId
    """)
    suspend fun incrementQuantity(bookId: Long, libraryId: Long)
}
