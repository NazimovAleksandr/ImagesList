package com.nazimovaleksandr.imageslist.di

import android.content.Context
import com.nazimovaleksandr.imageslist.presentation.screens.images_list.ImagesListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@AppScope
@Component(modules = [DomainModule::class, DataModule::class])
interface AppComponent {
    fun injectFragmentImagesList(fragment: ImagesListFragment)

    @Component.Factory
    interface AppComponentFactory {
        fun create(
            @BindsInstance
            context: Context
        ): AppComponent
    }

//    @Component.Builder
//    interface AppComponentBuilder {
//        @BindsInstance
//        fun context(context: Context): AppComponentBuilder
//
//        fun build(): AppComponent
//    }
}