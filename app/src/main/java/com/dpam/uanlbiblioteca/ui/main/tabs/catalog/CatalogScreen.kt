package com.dpam.uanlbiblioteca.ui.main.tabs.catalog

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.dpam.uanlbiblioteca.R
import com.dpam.uanlbiblioteca.ui.core.componets.ScreenLayout
import com.dpam.uanlbiblioteca.ui.core.componets.TopAppBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CatalogScreen(vm: CatalogViewModel = koinViewModel(), onBookClick: (Long) -> Unit) {
    val context = LocalContext.current
    val state by vm.state.collectAsState()

    ScreenLayout(topBar = { TopAppBar(title = context.getString(R.string.catalog)) }) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 125.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(items = state.bookList, key = { it.id }) { book ->
                BookCard(book = book, onClick = { onBookClick(book.id) })
            }
        }
    }
}