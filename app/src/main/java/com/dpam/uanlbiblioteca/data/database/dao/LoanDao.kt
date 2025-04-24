package com.dpam.uanlbiblioteca.data.database.dao

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface LoanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLoan(loan: LoanEntity)

    @Query("SELECT * FROM LoanEntity ORDER BY return_date ASC")
    fun getAllLoans(): Flow<List<LoanEntity>>

    @Query("SELECT * FROM LoanEntity WHERE id = :id")
    suspend fun getLoanById(id: Long): LoanEntity?

    @RequiresApi(Build.VERSION_CODES.O)
    @Query("UPDATE LoanEntity SET status = \"Devuelto\", return_date = :returnDate WHERE id = :id")
    suspend fun updateLoanStatusById(id: Long, returnDate: LocalDate = LocalDate.now())

    @Query("UPDATE LoanEntity SET due_date = :dueDate WHERE id = :id")
    suspend fun updateDueDateById(id: Long, dueDate: LocalDate)
}