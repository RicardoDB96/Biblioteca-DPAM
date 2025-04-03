package com.dpam.uanlbiblioteca.ui.main.tabs.catalog

import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails

data class CatalogState(
    val booksByCampus: List<BookWithDetails> = emptyList(),
    val booksByCategory: Map<String, List<BookWithDetails>> = emptyMap(),
    val recentlyAdded: List<BookWithDetails> = emptyList(),
    val searchResults: List<BookWithDetails> = emptyList(),
    val searchQuery: String = ""
)