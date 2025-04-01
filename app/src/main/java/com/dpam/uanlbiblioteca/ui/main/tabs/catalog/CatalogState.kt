package com.dpam.uanlbiblioteca.ui.main.tabs.catalog

import com.dpam.uanlbiblioteca.domain.model.BookModel

data class CatalogState(
    val bookList: List<BookModel> = emptyList(),
)