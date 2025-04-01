package com.dpam.uanlbiblioteca.di

import com.dpam.uanlbiblioteca.ui.main.tabs.catalog.CatalogViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::CatalogViewModel)
}