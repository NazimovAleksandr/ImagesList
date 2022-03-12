package com.nazimovaleksandr.imageslist.presentation.app

import android.app.Application
import com.nazimovaleksandr.imageslist.di.dataModule
import com.nazimovaleksandr.imageslist.di.domainModule
import com.nazimovaleksandr.imageslist.di.presentationModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    presentationModule,
                    domainModule,
                    dataModule
                )
            )
        }
    }
}