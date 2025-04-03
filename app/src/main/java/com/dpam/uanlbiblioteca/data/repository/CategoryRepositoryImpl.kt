package com.dpam.uanlbiblioteca.data.repository

import com.dpam.uanlbiblioteca.data.database.dao.CategoryDao
import com.dpam.uanlbiblioteca.data.database.entity.CategoryEntity
import com.dpam.uanlbiblioteca.domain.repository.CategoryRepository

class CategoryRepositoryImpl(private val categoryDao: CategoryDao) : CategoryRepository {
    override suspend fun insertCategories(categories: List<CategoryEntity>) {
        categoryDao.insertCategories(categories)
    }

    override suspend fun getAllCategories(): List<CategoryEntity> = categoryDao.getAllCategories()

    override suspend fun getCategoryById(categoryId: Long): CategoryEntity? {
        return categoryDao.getCategoryById(categoryId)
    }
}