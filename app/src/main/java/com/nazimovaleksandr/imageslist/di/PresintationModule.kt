package com.nazimovaleksandr.imageslist.di

import com.nazimovaleksandr.imageslist.presentation.screens.images_list.ImagesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        ImagesViewModel(getImagesList = get())
    }
}