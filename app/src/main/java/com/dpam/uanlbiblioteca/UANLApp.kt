package com.dpam.uanlbiblioteca

import android.app.Application
import com.dpam.uanlbiblioteca.di.dataModule
import com.dpam.uanlbiblioteca.di.domainModule
import com.dpam.uanlbiblioteca.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UANLApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@UANLApp)
            modules(dataModule, domainModule, uiModule)
        }
    }
}