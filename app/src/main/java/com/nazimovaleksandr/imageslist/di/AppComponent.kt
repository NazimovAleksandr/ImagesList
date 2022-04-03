package com.nazimovaleksandr.imageslist.di

import android.content.Context
import androidx.fragment.app.Fragment
import com.nazimovaleksandr.imageslist.presentation.screens.image.ImageFragment
import com.nazimovaleksandr.imageslist.presentation.screens.images_list.ImagesListFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [DomainModule::class, DataModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(fragment: ImagesListFragment)

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