package com.dpam.uanlbiblioteca.di

import com.dpam.uanlbiblioteca.ui.main.tabs.catalog.CatalogViewModel
import com.dpam.uanlbiblioteca.ui.main.tabs.profile.ProfileViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::CatalogViewModel)
    viewModelOf(::ProfileViewModel)
}