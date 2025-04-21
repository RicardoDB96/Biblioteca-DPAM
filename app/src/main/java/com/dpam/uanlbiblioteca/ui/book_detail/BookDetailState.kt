package com.dpam.uanlbiblioteca.ui.book_detail

import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity

data class BookDetailState(
    val isLoading: Boolean = false,
    val campusId: Long = -1,
    val bookDetails: BookWithDetails? = null,
    val bookAvailable: List<LibraryEntity> = emptyList(),
    val selectedLibrary: Long = -1,
    val selectedTime: Int = -1,
    val isLoanEnabled: Boolean = false,
)
