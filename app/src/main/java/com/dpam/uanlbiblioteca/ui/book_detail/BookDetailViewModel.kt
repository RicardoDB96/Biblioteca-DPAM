package com.dpam.uanlbiblioteca.ui.book_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import com.dpam.uanlbiblioteca.domain.repository.CampusRepository
import com.dpam.uanlbiblioteca.domain.repository.StudentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookDetailViewModel(
    private val bookId: Long,
    private val bookRepository: BookRepository,
    private val studentRepository: StudentRepository,
    private val campusRepository: CampusRepository,
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

    fun onLoanBook() {}
}