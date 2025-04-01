package com.dpam.uanlbiblioteca.data.repository

import com.dpam.uanlbiblioteca.data.database.dao.CampusDao
import com.dpam.uanlbiblioteca.data.database.entity.CampusEntity
import com.dpam.uanlbiblioteca.domain.repository.CampusRepository

class CampusRepositoryImpl(private val campusDao: CampusDao) : CampusRepository {
    override suspend fun saveAllCampus(campusList: List<CampusEntity>) {
        campusDao.insertCampuses(campusList)
    }

    override suspend fun getAllCampus(): List<CampusEntity> = campusDao.getAllCampuses()
}