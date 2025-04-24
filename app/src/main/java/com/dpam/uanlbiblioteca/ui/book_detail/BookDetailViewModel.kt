package com.dpam.uanlbiblioteca.ui.book_detail

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import com.dpam.uanlbiblioteca.domain.repository.CampusRepository
import com.dpam.uanlbiblioteca.domain.repository.LoanRepository
import com.dpam.uanlbiblioteca.domain.repository.StudentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

class BookDetailViewModel(
    private val bookId: Long,
    private val bookRepository: BookRepository,
    private val studentRepository: StudentRepository,
    private val campusRepository: CampusRepository,
    private val loanRepository: LoanRepository,
) :
    ViewModel() {

    private val _uiState = MutableStateFlow(BookDetailState())
    val state: StateFlow<BookDetailState> = _uiState.asStateFlow()

    init {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val student = studentRepository.getStudent()?.campus
            val campusId = campusRepository.getCampusIdByName(campusName = student ?: "")
            _uiState.update { it.copy(campusId = campusId ?: -1) }

            combine(
                bookRepository.getBookById(bookId),
                bookRepository.getBookAvailableLibraries(bookId)
            ) { book, bookAvailable ->
                book to bookAvailable
            }.collect { (book, availableLibraries) ->
                val bookAvailable = book.libraries.filter {
                    it.id in availableLibraries.filter { available -> available.quantity > 0 }
                        .map { available -> available.libraryId }
                }
                _uiState.update {
                    it.copy(
                        bookDetails = book,
                        bookAvailable = bookAvailable,
                        isLoading = false
                    )
                }
            }
        }
    }

    fun onLoanSelection(
        selectedLibrary: Long = state.value.selectedLibrary,
        selectedTime: Int = state.value.selectedTime,
    ) {
        _uiState.update {
            it.copy(
                selectedLibrary = selectedLibrary,
                selectedTime = selectedTime,
                isLoanEnabled = (selectedLibrary != -1L && selectedTime != -1)
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onLoanBook() {
        viewModelScope.launch {
            val studentId = studentRepository.getStudent()?.id ?: -1

            val loanDate = LocalDate.now()

            // selectedTime: 0 -> 7 días, 1 -> 14 días
            val daysToAdd = when (_uiState.value.selectedTime) {
                0 -> 7L
                1 -> 14L
                else -> 7L // valor por defecto en caso de error
            }

            val dueDate = loanDate.plusDays(daysToAdd)

            // Crear entidad de préstamo
            val loanEntity = LoanEntity(
                userId = studentId,
                bookId = bookId,
                loanDate = loanDate,
                returnDate = null, // aún no devuelto
                dueDate = dueDate,
                status = "En prestamo"
            )

            println(bookId)
            println(_uiState.value.selectedLibrary)

            bookRepository.decrementBookQuantity(
                bookId = bookId,
                libraryId = _uiState.value.selectedLibrary
            )
            loanRepository.saveLoan(loan = loanEntity)
            _uiState.update {
                it.copy(
                    isLoanEnabled = false,
                    selectedLibrary = -1,
                    selectedTime = -1
                )
            }
        }
    }
}