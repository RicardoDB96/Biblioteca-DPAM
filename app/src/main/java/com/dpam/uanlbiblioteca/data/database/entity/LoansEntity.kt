package com.dpam.uanlbiblioteca.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = BookEntity::class,
            parentColumns = ["book_id"],
            childColumns = ["book_id"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = StudentEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index(value = ["book_id"]),
        Index(value = ["user_id"])
    ]
)
data class LoanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "user_id")
    val userId: Long? = null,

    @ColumnInfo(name = "book_id")
    val bookId: Long? = null,

    @ColumnInfo(name = "loan_date")
    val loanDate: LocalDate? = null,

    @ColumnInfo(name = "return_date")
    val returnDate: LocalDate? = null,

    @ColumnInfo(name = "due_date")
    val dueDate: LocalDate? = null,

    val status: String? = null
)