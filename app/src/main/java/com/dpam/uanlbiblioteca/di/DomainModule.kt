package com.dpam.uanlbiblioteca.di

import com.dpam.uanlbiblioteca.data.repository.BookRepositoryImpl
import com.dpam.uanlbiblioteca.data.repository.CampusRepositoryImpl
import com.dpam.uanlbiblioteca.data.repository.CategoryRepositoryImpl
import com.dpam.uanlbiblioteca.data.repository.LibraryRepositoryImpl
import com.dpam.uanlbiblioteca.data.repository.LoanRepositoryImpl
import com.dpam.uanlbiblioteca.data.repository.MajorRepositoryImpl
import com.dpam.uanlbiblioteca.data.repository.StudentRepositoryImpl
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import com.dpam.uanlbiblioteca.domain.repository.CampusRepository
import com.dpam.uanlbiblioteca.domain.repository.CategoryRepository
import com.dpam.uanlbiblioteca.domain.repository.LibraryRepository
import com.dpam.uanlbiblioteca.domain.repository.LoanRepository
import com.dpam.uanlbiblioteca.domain.repository.MajorRepository
import com.dpam.uanlbiblioteca.domain.repository.StudentRepository
import org.koin.dsl.module

val domainModule = module {
    single<BookRepository> { BookRepositoryImpl(get(), get(), get()) }
    single<LibraryRepository> { LibraryRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<MajorRepository> { MajorRepositoryImpl(get()) }
    single<CampusRepository> { CampusRepositoryImpl(get()) }
    single<StudentRepository> { StudentRepositoryImpl(get(), get(), get()) }
    single<LoanRepository> { LoanRepositoryImpl(get(), get()) }
}