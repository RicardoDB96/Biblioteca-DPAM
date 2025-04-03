package com.dpam.uanlbiblioteca.domain.repository

import com.dpam.uanlbiblioteca.data.database.entity.CategoryEntity

interface CategoryRepository {
    suspend fun insertCategories(categories: List<CategoryEntity>)
    suspend fun getAllCategories(): List<CategoryEntity>
    suspend fun getCategoryById(categoryId: Long): CategoryEntity?
}