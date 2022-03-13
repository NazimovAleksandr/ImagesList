package com.nazimovaleksandr.imageslist.di

import android.content.Context
import com.nazimovaleksandr.imageslist.presentation.screens.images_list.ImagesListFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class, DataModule::class])
interface AppComponent {
    fun injectFragmentImagesList(fragment: ImagesListFragment)

    @Component.Builder
    interface AppComponentBuilder {
        @BindsInstance
        fun context(context: Context): AppComponentBuilder

        fun build(): AppComponent
    }
}