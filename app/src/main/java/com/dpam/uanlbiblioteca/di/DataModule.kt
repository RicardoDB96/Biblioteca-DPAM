package com.dpam.uanlbiblioteca.di

import androidx.room.Room
import com.dpam.uanlbiblioteca.data.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { // DB singleton
        Room.databaseBuilder(
            context = androidContext(),
            klass = AppDatabase::class.java,
            name = "app_database"
        ).build()
    }

    // Dao's
    single { get<AppDatabase>().bookDao() }
    single { get<AppDatabase>().studentDao() }
    single { get<AppDatabase>().majorDao() }
    single { get<AppDatabase>().campusDao() }
}