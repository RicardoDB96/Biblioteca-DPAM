package com.dpam.uanlbiblioteca.ui.main.tabs.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.dpam.uanlbiblioteca.R
import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails
import com.dpam.uanlbiblioteca.ui.core.componets.ScreenLayout
import com.dpam.uanlbiblioteca.ui.core.componets.TopAppBar
import com.dpam.uanlbiblioteca.ui.main.tabs.catalog.components.BookCard
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CatalogScreen(
    vm: CatalogViewModel = koinViewModel(),
    onBookClick: (Long) -> Unit
) {
    val context = LocalContext.current
    val state by vm.state.collectAsState()

    ScreenLayout(topBar = { TopAppBar(title = context.getString(R.string.catalog)) }) {
        // Barra de búsqueda
        SearchBar(
            query = state.searchQuery,
            onQueryChanged = { query -> vm.searchBooks(query) }
        )

        LazyColumn( // Permite hacer scroll vertical
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp) // Espacio para el final
        ) {
            if (state.searchQuery.isNotEmpty()) {
                item {
                    BooksList(
                        title = "Resultados de búsqueda",
                        books = state.searchResults,
                        onBookClick
                    )
                }
            } else {
                if (state.booksByCampus.isNotEmpty()) {
                    item {
                        BooksList(
                            title = "Disponibles en tu campus",
                            books = state.booksByCampus,
                            onBookClick = onBookClick
                        )
                    }
                }

                if (state.recentlyAdded.isNotEmpty()) {
                    item {
                        BooksList(
                            title = "Recientemente agregados",
                            books = state.recentlyAdded,
                            onBookClick = onBookClick
                        )
                    }
                }

                state.booksByCategory.forEach { (category, books) ->
                    item {
                        BooksList(title = category, books = books, onBookClick = onBookClick)
                    }
                }
            }
        }
    }
}


@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = { onQueryChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = { Text("Buscar libros...") }
    )
}

@Composable
fun BooksList(
    title: String,
    books: List<BookWithDetails>,
    onBookClick: (Long) -> Unit
) {
    if (books.isNotEmpty()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 4.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items = books, key = { it.book.id }) { book ->
                    BookCard(book = book.book.asDomain(), onClick = { onBookClick(book.book.id) })
                }
            }
        }
    }
}
