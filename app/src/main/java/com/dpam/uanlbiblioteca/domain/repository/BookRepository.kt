package com.dpam.uanlbiblioteca.domain.repository

import com.dpam.uanlbiblioteca.data.database.entity.BookCategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookLibraryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails
import com.dpam.uanlbiblioteca.data.database.entity.CampusEntity
import com.dpam.uanlbiblioteca.data.database.entity.CategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity
import com.dpam.uanlbiblioteca.domain.model.BookModel
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun saveBooks(books: List<BookModel>)
    suspend fun saveBookCategoriesAndLibraries(
        bookCategories: List<BookCategoryEntity>,
        bookLibraries: List<BookLibraryEntity>
    )

    suspend fun saveAll(
        books: List<BookEntity>,
        campuses: List<CampusEntity>,
        categories: List<CategoryEntity>,
        libraries: List<LibraryEntity>,
        bookCategories: List<BookCategoryEntity>,
        bookLibraries: List<BookLibraryEntity>
    )

    fun getBooks(): Flow<List<BookWithDetails>>
    fun searchBooks(query: String): Flow<List<BookWithDetails>>
    fun getBookById(bookId: Long): Flow<BookWithDetails>
    fun getBookAvailableLibraries(bookId: Long): Flow<List<BookLibraryEntity>>
}