package com.dpam.uanlbiblioteca.domain.model

import com.dpam.uanlbiblioteca.data.database.entity.BookEntity

data class BookModel(
    val id: Long = 0,
    val title: String,
    val author: String,
    val category: Int,
    val availability: Boolean,
    val location: String,
    val imageUrl: String,
    val isbn: String
) {
    fun asEntity() = BookEntity(
        title = title,
        author = author,
        category = category,
        availability = availability,
        location = location,
        imageUrl = imageUrl,
        isbn = isbn
    )
}

fun List<BookModel>.asEntity() = map { it.asEntity() }
