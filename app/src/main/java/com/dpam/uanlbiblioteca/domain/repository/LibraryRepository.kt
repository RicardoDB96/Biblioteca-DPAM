package com.dpam.uanlbiblioteca.domain.repository

import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity

interface LibraryRepository {
    suspend fun insertLibraries(libraries: List<LibraryEntity>)
    suspend fun getLibraries(): List<LibraryEntity>
    suspend fun getLibraryById(libraryId: Long): LibraryEntity?
}