package com.dpam.uanlbiblioteca.ui.main.tabs.loans

import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails
import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity

data class LoanState(
    val loans: List<LoanEntity> = emptyList(),
    val books: List<BookWithDetails?> = emptyList(),
)
