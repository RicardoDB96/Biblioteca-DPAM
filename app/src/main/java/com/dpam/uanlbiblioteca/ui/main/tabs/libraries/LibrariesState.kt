package com.dpam.uanlbiblioteca.ui.main.tabs.libraries

import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity

data class LibrariesState(
    val isLoading: Boolean = false,
    val libraries: List<LibraryEntity> = emptyList(),
)
