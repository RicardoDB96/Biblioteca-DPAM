package com.dpam.uanlbiblioteca.data.repository

import com.dpam.uanlbiblioteca.data.database.dao.BookCategoryDao
import com.dpam.uanlbiblioteca.data.database.dao.BookDao
import com.dpam.uanlbiblioteca.data.database.dao.BookLibraryDao
import com.dpam.uanlbiblioteca.data.database.entity.BookCategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookLibraryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails
import com.dpam.uanlbiblioteca.data.database.entity.CampusEntity
import com.dpam.uanlbiblioteca.data.database.entity.CategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity
import com.dpam.uanlbiblioteca.domain.model.BookModel
import com.dpam.uanlbiblioteca.domain.model.asEntity
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class BookRepositoryImpl(
    private val bookDao: BookDao,
    private val bookCategoryDao: BookCategoryDao,
    private val bookLibraryDao: BookLibraryDao
) : BookRepository {
    override suspend fun saveBooks(books: List<BookModel>) {
        bookDao.insertBooks(books.asEntity())
    }

    override suspend fun saveBookCategoriesAndLibraries(
        bookCategories: List<BookCategoryEntity>,
        bookLibraries: List<BookLibraryEntity>
    ) {
        bookCategoryDao.insertBookCategories(bookCategories)
        bookLibraryDao.insertBookLibraryRelations(bookLibraries)
    }

    override suspend fun saveAll(
        books: List<BookEntity>,
        campuses: List<CampusEntity>,
        categories: List<CategoryEntity>,
        libraries: List<LibraryEntity>,
        bookCategories: List<BookCategoryEntity>,
        bookLibraries: List<BookLibraryEntity>
    ) {
        bookDao.insertAllData(books, campuses, categories, libraries, bookCategories, bookLibraries)
    }

    override fun getBooks(): Flow<List<BookWithDetails>> {
        return bookDao.getBooksWithDetails()
    }

    override fun searchBooks(query: String): Flow<List<BookWithDetails>> {
        return bookDao.searchBooks(query)
    }
}