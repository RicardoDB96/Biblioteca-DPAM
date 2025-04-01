package com.dpam.uanlbiblioteca.domain.repository

import com.dpam.uanlbiblioteca.domain.model.StudentModel

interface StudentRepository {
    suspend fun save(student: StudentModel)
    suspend fun getStudent(): StudentModel?
}