package com.dpam.uanlbiblioteca.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dpam.uanlbiblioteca.domain.model.BookModel

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val author: String,
    val category: Int,
    val availability: Boolean,
    val location: String,
    val imageUrl: String,
    val isbn: String
) {
    fun asDomain() = BookModel(
        id = id,
        title = title,
        author = author,
        category = category,
        availability = availability,
        location = location,
        imageUrl = imageUrl,
        isbn = isbn
    )
}

fun List<BookEntity>.asDomain() = map { it.asDomain() }
