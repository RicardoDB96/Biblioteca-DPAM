package com.dpam.uanlbiblioteca.domain.repository

import com.dpam.uanlbiblioteca.domain.model.BookModel
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun saveBooks(books: List<BookModel>)
    fun getBooks(): Flow<List<BookModel>>
}