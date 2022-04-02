package com.nazimovaleksandr.imageslist.di

import androidx.lifecycle.ViewModel
import com.nazimovaleksandr.domain.DomainContract
import com.nazimovaleksandr.imageslist.presentation.screens.images_list.ImagesViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @IntoMap
    @ViewModelKey(ImagesViewModel::class)
    @Provides
    fun provideImagesViewModelProd(
        @Prod
        getImagesList: DomainContract.GetImagesListUseCase
    ): ViewModel {
        return ImagesViewModel(getImagesList)
    }
}