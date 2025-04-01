package com.dpam.uanlbiblioteca.di

import com.dpam.uanlbiblioteca.data.repository.BookRepositoryImpl
import com.dpam.uanlbiblioteca.data.repository.CampusRepositoryImpl
import com.dpam.uanlbiblioteca.data.repository.MajorRepositoryImpl
import com.dpam.uanlbiblioteca.data.repository.StudentRepositoryImpl
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import com.dpam.uanlbiblioteca.domain.repository.CampusRepository
import com.dpam.uanlbiblioteca.domain.repository.MajorRepository
import com.dpam.uanlbiblioteca.domain.repository.StudentRepository
import org.koin.dsl.module

val domainModule = module {
    single<BookRepository> { BookRepositoryImpl(get()) }
    single<MajorRepository> { MajorRepositoryImpl(get()) }
    single<CampusRepository> { CampusRepositoryImpl(get()) }
    single<StudentRepository> { StudentRepositoryImpl(get(), get(), get()) }
}