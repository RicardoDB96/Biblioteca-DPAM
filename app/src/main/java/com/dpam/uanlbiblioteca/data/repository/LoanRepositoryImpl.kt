package com.dpam.uanlbiblioteca.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.dpam.uanlbiblioteca.data.database.dao.BookLibraryDao
import com.dpam.uanlbiblioteca.data.database.dao.LoanDao
import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity
import com.dpam.uanlbiblioteca.domain.repository.LoanRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class LoanRepositoryImpl(private val loanDao: LoanDao, private val bookLibraryDao: BookLibraryDao) : LoanRepository {
    override suspend fun saveLoan(loan: LoanEntity) {
        loanDao.insertLoan(loan)
    }

    override fun getLoans(): Flow<List<LoanEntity>> {
        return loanDao.getAllLoans()
    }

    override suspend fun getLoanById(id: Long): LoanEntity? {
        return loanDao.getLoanById(id)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun returnLoan(id: Long, bookId: Long) {
        loanDao.updateLoanStatusById(id)
        val libraryId = bookLibraryDao.getRandomLibraryId(bookId)

        println("Library ID: $libraryId")
        println("Book ID: $bookId")
        bookLibraryDao.incrementQuantity(bookId, libraryId ?: 1)
    }

    override suspend fun updateLoan(id: Long, newDueDate: LocalDate) {
        loanDao.updateDueDateById(id = id, dueDate = newDueDate)
    }
}