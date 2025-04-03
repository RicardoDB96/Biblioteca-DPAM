package com.dpam.uanlbiblioteca.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.dpam.uanlbiblioteca.domain.model.BookModel

@Entity(indices = [Index(value = ["isbn"], unique = true)])
data class BookEntity(
    @PrimaryKey
    @ColumnInfo(name = "book_id") val id: Long = 0,
    val title: String,
    val author: String,
    val isbn: String?,
    val imageUrl: String?
) {
    fun asDomain() = BookModel(
        id = id,
        title = title,
        author = author,
        imageUrl = imageUrl,
        isbn = isbn
    )
}

fun List<BookEntity>.asDomain() = map { it.asDomain() }

data class BookWithDetails(
    @Embedded val book: BookEntity,

    @Relation(
        parentColumn = "book_id", // Debe coincidir con la columna en BookEntity
        entityColumn = "category_id", // Coincide con el campo en BookCategoryEntity
        associateBy = Junction(BookCategoryEntity::class)
    )
    val categories: List<CategoryEntity>,

    @Relation(
        parentColumn = "book_id", // Debe coincidir con la columna en BookEntity
        entityColumn = "library_id", // Coincide con el campo en BookLibraryEntity
        associateBy = Junction(BookLibraryEntity::class)
    )
    val libraries: List<LibraryEntity>
)