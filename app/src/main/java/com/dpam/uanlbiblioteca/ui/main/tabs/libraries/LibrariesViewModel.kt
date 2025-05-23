package com.dpam.uanlbiblioteca.ui.main.tabs.libraries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpam.uanlbiblioteca.domain.repository.CampusRepository
import com.dpam.uanlbiblioteca.domain.repository.LibraryRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LibrariesViewModel(
    private val libraryRepository: LibraryRepository,
    private val campusRepository: CampusRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LibrariesState())
    val state: StateFlow<LibrariesState> = _uiState.asStateFlow()

    init {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            delay(200)
            _uiState.update {
                it.copy(
                    isLoading = false,
                    libraries = libraryRepository.getLibraries(),
                    campuses = campusRepository.getAllCampus()
                )
            }
        }
    }
}