package com.dpam.uanlbiblioteca.domain.repository

import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity
import kotlinx.coroutines.flow.Flow

interface LoanRepository {
    suspend fun saveLoan(loan: LoanEntity)
    fun getLoans(): Flow<List<LoanEntity>>
    suspend fun getLoanById(id: Int): LoanEntity?
}