package com.dpam.uanlbiblioteca.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    primaryKeys = ["book_id", "category_id"],
    foreignKeys = [
        ForeignKey(entity = BookEntity::class, parentColumns = ["book_id"], childColumns = ["book_id"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = CategoryEntity::class, parentColumns = ["category_id"], childColumns = ["category_id"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["category_id", "book_id"])]
)
data class BookCategoryEntity(
    @ColumnInfo(name = "book_id") val bookId: Long,
    @ColumnInfo(name = "category_id") val categoryId: Long
)
