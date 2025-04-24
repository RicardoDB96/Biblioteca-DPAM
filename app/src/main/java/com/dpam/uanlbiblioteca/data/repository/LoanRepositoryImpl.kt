package com.dpam.uanlbiblioteca.data.repository

import com.dpam.uanlbiblioteca.data.database.dao.LoanDao
import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity
import com.dpam.uanlbiblioteca.domain.repository.LoanRepository
import kotlinx.coroutines.flow.Flow

class LoanRepositoryImpl(private val loanDao: LoanDao) : LoanRepository {
    override suspend fun saveLoan(loan: LoanEntity) {
        loanDao.insertLoan(loan)
    }

    override fun getLoans(): Flow<List<LoanEntity>> {
        return loanDao.getAllLoans()
    }

    override suspend fun getLoanById(id: Int): LoanEntity? {
        return loanDao.getLoanById(id)
    }
}