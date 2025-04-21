package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.dpam.uanlbiblioteca.data.database.entity.BookCategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookLibraryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails
import com.dpam.uanlbiblioteca.data.database.entity.CampusEntity
import com.dpam.uanlbiblioteca.data.database.entity.CategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: List<BookEntity>)

    @Query("SELECT * FROM BookEntity")
    fun getAllBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM BookEntity WHERE book_id = :bookId")
    fun getBookById(bookId: Long): Flow<BookWithDetails>

    @Transaction
    @Query("SELECT * FROM BookEntity")
    fun getBooksWithDetails(): Flow<List<BookWithDetails>>

    @Transaction
    @Query("""
        SELECT * FROM BookEntity 
        WHERE title LIKE '%' || :query || '%' 
        OR author LIKE '%' || :query || '%'
    """)
    fun searchBooks(query: String): Flow<List<BookWithDetails>>

    @Transaction
    suspend fun insertAllData(
        books: List<BookEntity>,
        campuses: List<CampusEntity>,
        categories: List<CategoryEntity>,
        libraries: List<LibraryEntity>,
        bookCategories: List<BookCategoryEntity>,
        bookLibraries: List<BookLibraryEntity>
    ) {
        insertBooks(books)
        insertCampuses(campuses)
        insertCategories(categories)
        insertLibraries(libraries)
        insertBookCategories(bookCategories)
        insertBookLibraries(bookLibraries)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCampuses(campuses: List<CampusEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoryEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLibraries(libraries: List<LibraryEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookCategories(bookCategories: List<BookCategoryEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookLibraries(bookLibraries: List<BookLibraryEntity>)
}