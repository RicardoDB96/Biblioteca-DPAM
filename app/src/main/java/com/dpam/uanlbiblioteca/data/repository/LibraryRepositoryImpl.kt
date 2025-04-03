package com.dpam.uanlbiblioteca.data.repository

import com.dpam.uanlbiblioteca.data.database.dao.LibraryDao
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity
import com.dpam.uanlbiblioteca.domain.repository.LibraryRepository

class LibraryRepositoryImpl(private val libraryDao: LibraryDao): LibraryRepository {
    override suspend fun insertLibraries(libraries: List<LibraryEntity>) {
        libraryDao.insertLibraries(libraries)
    }

    override suspend fun getLibraries(): List<LibraryEntity> = libraryDao.getAllLibraries()

    override suspend fun getLibraryById(libraryId: Long): LibraryEntity? {
        return libraryDao.getLibraryById(libraryId)
    }
}