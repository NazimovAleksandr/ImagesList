package com.nazimovaleksandr.imageslist.di

import android.content.Context
import com.nazimovaleksandr.domain.DomainContract
import com.nazimovaleksandr.imageslist.presentation.screens.images_list.ImagesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideGetContext(): Context {
        return context
    }
}