package com.dpam.uanlbiblioteca.ui.main.tabs.loans

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import com.dpam.uanlbiblioteca.domain.repository.LoanRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

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
            }.collect {}
        }
    }

    fun onLoanClick(id: Long) {
        viewModelScope.launch {
            val loan = loansRepository.getLoanById(id)
            _uiState.update { it.copy(selectedLoan = loan) }
        }
    }

    fun onLoanReturn() {
        viewModelScope.launch {
            delay(450)
            val loan = _uiState.value.selectedLoan!!
            loansRepository.returnLoan(loan.id, loan.bookId ?: 0)
            _uiState.update { it.copy(selectedLoan = null) }
            onLoanCancel()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onLoanRenew() {
        viewModelScope.launch {
            val loanDate = LocalDate.now()

            // selectedTime: 0 -> 7 días, 1 -> 14 días
            val daysToAdd = when (_uiState.value.selectedTime) {
                0 -> 7L
                1 -> 14L
                else -> 7L // valor por defecto en caso de error
            }

            val dueDate = loanDate.plusDays(daysToAdd)

            loansRepository.updateLoan(uiState.value.selectedLoan!!.id, dueDate)
            _uiState.update { it.copy(selectedLoan = null) }
            onLoanCancel()
        }
    }

    fun onLoanSelection(
        selectedTime: Int = uiState.value.selectedTime,
    ) {
        _uiState.update {
            it.copy(
                selectedTime = selectedTime,
                isRenovateEnabled = selectedTime != -1
            )
        }
    }

    fun onLoanCancel() {
        _uiState.update {
            it.copy(
                selectedLoan = null,
                selectedTime = -1,
                isRenovateEnabled = false,
            )
        }
    }
}