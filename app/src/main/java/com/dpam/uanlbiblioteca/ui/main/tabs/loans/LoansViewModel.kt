package com.dpam.uanlbiblioteca.ui.main.tabs.loans

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import com.dpam.uanlbiblioteca.domain.repository.LoanRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoansViewModel(
    private val loansRepository: LoanRepository,
    private val booksRepository: BookRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoanState())
    val uiState: StateFlow<LoanState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            combine(loansRepository.getLoans(), booksRepository.getBooks()) { loans, books ->
                _uiState.update { it.copy(loans = loans, books = books) }
            }.collect{}
        }
    }
}