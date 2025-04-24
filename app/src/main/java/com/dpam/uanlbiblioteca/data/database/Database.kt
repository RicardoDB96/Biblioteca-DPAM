package com.dpam.uanlbiblioteca.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dpam.uanlbiblioteca.data.database.dao.BookCategoryDao
import com.dpam.uanlbiblioteca.data.database.dao.BookDao
import com.dpam.uanlbiblioteca.data.database.dao.BookLibraryDao
import com.dpam.uanlbiblioteca.data.database.dao.CampusDao
import com.dpam.uanlbiblioteca.data.database.dao.CategoryDao
import com.dpam.uanlbiblioteca.data.database.dao.LibraryDao
import com.dpam.uanlbiblioteca.data.database.dao.LoanDao
import com.dpam.uanlbiblioteca.data.database.dao.MajorDao
import com.dpam.uanlbiblioteca.data.database.dao.StudentDao
import com.dpam.uanlbiblioteca.data.database.entity.BookCategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookEntity
import com.dpam.uanlbiblioteca.data.database.entity.BookLibraryEntity
import com.dpam.uanlbiblioteca.data.database.entity.CampusEntity
import com.dpam.uanlbiblioteca.data.database.entity.CategoryEntity
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity
import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity
import com.dpam.uanlbiblioteca.data.database.entity.MajorEntity
import com.dpam.uanlbiblioteca.data.database.entity.StudentEntity

@Database(
    entities = [BookEntity::class, LibraryEntity::class, BookLibraryEntity::class, CategoryEntity::class, BookCategoryEntity::class, StudentEntity::class, MajorEntity::class, CampusEntity::class, LoanEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun libraryDao(): LibraryDao
    abstract fun bookLibraryDao(): BookLibraryDao
    abstract fun categoryDao(): CategoryDao
    abstract fun bookCategoryDao(): BookCategoryDao
    abstract fun studentDao(): StudentDao
    abstract fun majorDao(): MajorDao
    abstract fun campusDao(): CampusDao
    abstract fun loanDao(): LoanDao
}