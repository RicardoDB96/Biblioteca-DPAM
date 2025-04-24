package com.dpam.uanlbiblioteca.ui.main.tabs.loans

import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails
import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity

data class LoanState(
    val loans: List<LoanEntity> = emptyList(),
    val books: List<BookWithDetails?> = emptyList(),
    val selectedLoan: LoanEntity? = null,
    val selectedTime: Int = -1,
    val isRenovateEnabled: Boolean = false,
)
