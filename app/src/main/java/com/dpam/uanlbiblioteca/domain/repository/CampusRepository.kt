package com.dpam.uanlbiblioteca.domain.repository

import com.dpam.uanlbiblioteca.data.database.entity.CampusEntity

interface CampusRepository {
    suspend fun saveAllCampus(campusList: List<CampusEntity>)
    suspend fun getAllCampus(): List<CampusEntity>
    suspend fun getCampusIdByName(campusName: String): Long?
}