package com.nazimovaleksandr.imageslist.di

import com.nazimovaleksandr.data.DataContract
import com.nazimovaleksandr.domain.DomainContract
import com.nazimovaleksandr.domain.use_case.GetImagesListUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Prod
    @Provides
    fun provideGetImagesListUseCaseProd(
        @Prod
        dataManager: DataContract.Manager
    ): DomainContract.GetImagesListUseCase {
        return GetImagesListUseCase(dataManager)
    }

    @Dev
    @Provides
    fun provideGetImagesListUseCaseDev(
        @Dev
        dataManager: DataContract.Manager
    ): DomainContract.GetImagesListUseCase {
        return GetImagesListUseCase(dataManager)
    }
}