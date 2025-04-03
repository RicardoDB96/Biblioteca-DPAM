package com.dpam.uanlbiblioteca.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dpam.uanlbiblioteca.data.database.entity.CategoryEntity

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoryEntity>)

    @Query("SELECT * FROM CategoryEntity")
    suspend fun getAllCategories(): List<CategoryEntity>

    @Query("SELECT * FROM CategoryEntity WHERE category_id = :categoryId")
    suspend fun getCategoryById(categoryId: Long): CategoryEntity?
}