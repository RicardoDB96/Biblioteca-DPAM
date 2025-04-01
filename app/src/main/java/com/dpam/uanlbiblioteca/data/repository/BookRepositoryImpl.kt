package com.dpam.uanlbiblioteca.data.repository

import com.dpam.uanlbiblioteca.data.database.dao.BookDao
import com.dpam.uanlbiblioteca.data.database.entity.asDomain
import com.dpam.uanlbiblioteca.domain.model.BookModel
import com.dpam.uanlbiblioteca.domain.model.asEntity
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookRepositoryImpl(private val bookDao: BookDao) : BookRepository {
    override suspend fun saveBooks(books: List<BookModel>) {
        bookDao.insertBooks(books.asEntity())
    }

    override fun getBooks(): Flow<List<BookModel>> {
        return bookDao.getAllBooks().map { it.asDomain() }
    }
}