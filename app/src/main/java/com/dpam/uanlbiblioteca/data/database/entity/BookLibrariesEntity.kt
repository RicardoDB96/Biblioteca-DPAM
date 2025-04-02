package com.dpam.uanlbiblioteca.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.Junction
import androidx.room.Relation

@Entity(
    primaryKeys = ["book_id", "library_id"],
    foreignKeys = [
        ForeignKey(
            entity = BookEntity::class,
            parentColumns = ["id"],
            childColumns = ["book_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = LibraryEntity::class,
            parentColumns = ["id"],
            childColumns = ["library_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["book_id"]),
        Index(value = ["library_id"])
    ]
)
data class BookLibraryEntity(
    @ColumnInfo(name = "book_id") val bookId: Long,
    @ColumnInfo(name = "library_id") val libraryId: Long,
    @ColumnInfo(name = "quantity") val quantity: Int = 0
)

data class BookWithLibraries(
    @Embedded val book: BookEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(BookLibraryEntity::class, parentColumn = "book_id", entityColumn = "library_id")
    )
    val libraries: List<LibraryEntity>
)