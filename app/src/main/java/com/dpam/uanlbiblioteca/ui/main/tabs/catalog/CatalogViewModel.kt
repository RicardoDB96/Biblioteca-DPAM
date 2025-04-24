package com.dpam.uanlbiblioteca.ui.main.tabs.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import com.dpam.uanlbiblioteca.domain.repository.CampusRepository
import com.dpam.uanlbiblioteca.domain.repository.StudentRepository
import com.dpam.uanlbiblioteca.utils.SampleList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CatalogViewModel(
    private val bookRepository: BookRepository,
    private val studentRepository: StudentRepository,
    private val campusRepository: CampusRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CatalogState())
    val state: StateFlow<CatalogState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(675)
            bookRepository.saveAll(
                books = SampleList.books,
                campuses = SampleList.faculties,
                categories = SampleList.categories,
                libraries = SampleList.libraries,
                bookCategories = SampleList.bookCategories,
                bookLibraries = SampleList.bookLibraries
            )

            bookRepository.getBooks().collect { books ->
                val student = studentRepository.getStudent()
                val campusId =
                    campusRepository.getCampusIdByName(campusName = student?.campus ?: "")

                _uiState.value = _uiState.value.copy(
                    booksByCampus = filterBooksByCampus(books = books, campusId = campusId),
                    booksByCategory = groupBooksByCategory(books),
                    recentlyAdded = books.sortedByDescending { it.book.id }.take(10)
                )
            }
        }
    }

    fun searchBooks(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
        viewModelScope.launch {
            bookRepository.searchBooks(query).collect { results ->
                _uiState.value = _uiState.value.copy(searchResults = results)
            }
        }
    }

    private fun filterBooksByCampus(
        books: List<BookWithDetails>,
        campusId: Long?
    ): List<BookWithDetails> {
        return books.filter { book -> book.libraries.any { it.campusId == campusId } }
    }

    private fun groupBooksByCategory(books: List<BookWithDetails>): Map<String, List<BookWithDetails>> {
        return books.flatMap { book ->
            book.categories.map { category -> category.name to book }
        }.groupBy({ it.first }, { it.second })
    }
}