package com.dpam.uanlbiblioteca.data.repository

import com.dpam.uanlbiblioteca.data.database.dao.MajorDao
import com.dpam.uanlbiblioteca.data.database.entity.MajorEntity
import com.dpam.uanlbiblioteca.domain.repository.MajorRepository

class MajorRepositoryImpl(private val majorDao: MajorDao) : MajorRepository {
    override suspend fun saveAllMajors(majors: List<MajorEntity>) {
        majorDao.insertMajors(majors)
    }

    override suspend fun getAllMajors(): List<MajorEntity> = majorDao.getAllMajors()
}