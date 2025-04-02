package com.dpam.uanlbiblioteca.ui.main.tabs.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpam.uanlbiblioteca.domain.model.BookModel
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatalogViewModel(private val bookRepository: BookRepository) : ViewModel() {

    private val _state = MutableStateFlow(CatalogState())
    val state: StateFlow<CatalogState> = _state.asStateFlow()

    private val sampleBooks = listOf(
        BookModel(id = 1, title = "The Hobbit", author = "J.R.R. Tolkien", category = "Fantasy", location = "Shelf A3", isbn = "9780547928227", imageUrl = "https://covers.openlibrary.org/b/isbn/9780547928227-L.jpg"),
        BookModel(id = 2, title = "1984", author = "George Orwell", category = "2", location = "Shelf B1", isbn = "9780451524935", imageUrl = "https://covers.openlibrary.org/b/isbn/9780451524935-L.jpg"),
        BookModel(id = 3, title = "To Kill a Mockingbird", author = "Harper Lee", category = "3", location = "Shelf C2", isbn = "9780061120084", imageUrl = "https://covers.openlibrary.org/b/isbn/9780061120084-L.jpg"),
        BookModel(id = 4, title = "The Great Gatsby", author = "F. Scott Fitzgerald", category = "3", location = "Shelf A5", isbn = "9780743273565", imageUrl = "https://covers.openlibrary.org/b/isbn/9780743273565-L.jpg"),
        BookModel(id = 5, title = "Moby Dick", author = "Herman Melville", category = "4", location = "Shelf D3", isbn = "9781503280786", imageUrl = "https://covers.openlibrary.org/b/isbn/9781503280786-L.jpg"),
        BookModel(id = 6, title = "Pride and Prejudice", author = "Jane Austen", category = "5", location = "Shelf E1", isbn = "9781503290563", imageUrl = "https://covers.openlibrary.org/b/isbn/9781503290563-L.jpg"),
        BookModel(id = 7, title = "Brave New World", author = "Aldous Huxley", category = "2", location = "Shelf B2", isbn = "9780060850524", imageUrl = "https://covers.openlibrary.org/b/isbn/9780060850524-L.jpg"),
        BookModel(id = 8, title = "The Catcher in the Rye", author = "J.D. Salinger", category = "3", location = "Shelf C4", isbn = "9780316769488", imageUrl = "https://covers.openlibrary.org/b/isbn/9780316769488-L.jpg"),
        BookModel(id = 9, title = "War and Peace", author = "Leo Tolstoy", category = "6", location = "Shelf F1", isbn = "9780199232765", imageUrl = "https://covers.openlibrary.org/b/isbn/9780199232765-L.jpg"),
        BookModel(id = 10, title = "Crime and Punishment", author = "Fyodor Dostoevsky", category = "7", location = "Shelf G3", isbn = "9780486415871", imageUrl = "https://covers.openlibrary.org/b/isbn/9780486415871-L.jpg"),
        BookModel(id = 11, title = "The Lord of the Rings", author = "J.R.R. Tolkien", category = "1", location = "Shelf A1", isbn = "9780261102385", imageUrl = "https://covers.openlibrary.org/b/isbn/9780261102385-L.jpg"),
        BookModel(id = 12, title = "The Alchemist", author = "Paulo Coelho", category = "8", location = "Shelf H2", isbn = "9780061122415", imageUrl = "https://covers.openlibrary.org/b/isbn/9780061122415-L.jpg")
    )



    init {
        viewModelScope.launch {
            bookRepository.saveBooks(sampleBooks)

            bookRepository.getBooks().collect { books ->
                _state.value = _state.value.copy(
                    bookList = books
                )
            }
        }
    }
}