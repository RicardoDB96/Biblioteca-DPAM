package com.dpam.uanlbiblioteca.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dpam.uanlbiblioteca.data.database.dao.BookDao
import com.dpam.uanlbiblioteca.data.database.entity.BookEntity

@Database(entities = [BookEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao
}