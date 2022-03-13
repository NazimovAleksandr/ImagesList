package com.nazimovaleksandr.imageslist.di

import com.nazimovaleksandr.imageslist.presentation.screens.images_list.ImagesListFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun injectFragmentImagesList(fragment: ImagesListFragment)
}