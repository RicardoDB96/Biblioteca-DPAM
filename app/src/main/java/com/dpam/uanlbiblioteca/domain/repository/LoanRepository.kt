package com.dpam.uanlbiblioteca.domain.repository

import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface LoanRepository {
    suspend fun saveLoan(loan: LoanEntity)
    fun getLoans(): Flow<List<LoanEntity>>
    suspend fun getLoanById(id: Long): LoanEntity?
    suspend fun returnLoan(id: Long, bookId: Long)
    suspend fun updateLoan(id: Long, newDueDate: LocalDate)
}