package com.dpam.uanlbiblioteca.domain.repository

import com.dpam.uanlbiblioteca.data.database.entity.MajorEntity

interface MajorRepository {
    suspend fun saveAllMajors(majors: List<MajorEntity>)
    suspend fun getAllMajors(): List<MajorEntity>
}