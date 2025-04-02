package com.dpam.uanlbiblioteca.data.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.dpam.uanlbiblioteca.domain.model.BookModel

@Entity(indices = [Index(value = ["isbn"], unique = true)])
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val author: String,
    val category: String,
    val location: String?,
    val isbn: String?,
    val imageUrl: String?
) {
    fun asDomain() = BookModel(
        id = id,
        title = title,
        author = author,
        category = category,
        location = location,
        imageUrl = imageUrl,
        isbn = isbn
    )
}

fun List<BookEntity>.asDomain() = map { it.asDomain() }
