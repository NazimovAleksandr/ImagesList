package com.nazimovaleksandr.imageslist.di

import com.nazimovaleksandr.domain.DomainContract
import com.nazimovaleksandr.domain.use_case.GetImagesListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<DomainContract.GetImagesListUseCase> {
        GetImagesListUseCase(manager = get())
    }
}