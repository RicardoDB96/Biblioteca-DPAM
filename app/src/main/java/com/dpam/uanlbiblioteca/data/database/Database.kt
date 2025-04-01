package com.dpam.uanlbiblioteca.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dpam.uanlbiblioteca.data.database.dao.BookDao
import com.dpam.uanlbiblioteca.data.database.dao.CampusDao
import com.dpam.uanlbiblioteca.data.database.dao.MajorDao
import com.dpam.uanlbiblioteca.data.database.dao.StudentDao
import com.dpam.uanlbiblioteca.data.database.entity.BookEntity
import com.dpam.uanlbiblioteca.data.database.entity.CampusEntity
import com.dpam.uanlbiblioteca.data.database.entity.MajorEntity
import com.dpam.uanlbiblioteca.data.database.entity.StudentEntity

@Database(
    entities = [BookEntity::class, StudentEntity::class, MajorEntity::class, CampusEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun studentDao(): StudentDao
    abstract fun majorDao(): MajorDao
    abstract fun campusDao(): CampusDao
}