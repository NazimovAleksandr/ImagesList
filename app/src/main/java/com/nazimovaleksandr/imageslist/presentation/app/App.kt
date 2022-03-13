package com.nazimovaleksandr.imageslist.presentation.app

import android.app.Application
import com.nazimovaleksandr.imageslist.di.AppComponent
import com.nazimovaleksandr.imageslist.di.AppModule
import com.nazimovaleksandr.imageslist.di.DaggerAppComponent

class App : Application() {
    val appComponent: AppComponent =  DaggerAppComponent
        .builder()
        .appModule(AppModule(this))
        .build()
}