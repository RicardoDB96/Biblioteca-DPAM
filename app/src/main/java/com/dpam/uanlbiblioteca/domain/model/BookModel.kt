package com.dpam.uanlbiblioteca.domain.model

import com.dpam.uanlbiblioteca.data.database.entity.BookEntity

data class BookModel(
    val id: Long = 0,
    val title: String,
    val author: String,
    val isbn: String?,
    val imageUrl: String?
) {
    fun asEntity() = BookEntity(
        title = title,
        author = author,
        imageUrl = imageUrl,
        isbn = isbn
    )
}

fun List<BookModel>.asEntity() = map { it.asEntity() }
