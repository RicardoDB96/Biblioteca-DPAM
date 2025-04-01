package com.dpam.uanlbiblioteca.di

import com.dpam.uanlbiblioteca.data.repository.BookRepositoryImpl
import com.dpam.uanlbiblioteca.domain.repository.BookRepository
import org.koin.dsl.module

val domainModule = module {
    single<BookRepository> { BookRepositoryImpl(get()) }
}