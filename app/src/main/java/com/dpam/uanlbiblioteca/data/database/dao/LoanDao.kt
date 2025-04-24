package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LoanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLoan(loan: LoanEntity)

    @Query("SELECT * FROM LoanEntity")
    fun getAllLoans(): Flow<List<LoanEntity>>

    @Query("SELECT * FROM LoanEntity WHERE id = :id")
    suspend fun getLoanById(id: Int): LoanEntity?
}