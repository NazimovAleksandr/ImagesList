package com.nazimovaleksandr.imageslist.presentation.screens.images_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nazimovaleksandr.data.DataFactory
import com.nazimovaleksandr.domain.DomainContract
import com.nazimovaleksandr.domain.use_case.GetImagesListUseCase

class ImagesViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImagesViewModel::class.java)) {
            val manager = DataFactory.getManager()
            val getImagesList: DomainContract.GetImagesListUseCase = GetImagesListUseCase(manager)

            return ImagesViewModel(getImagesList) as T
        }

        throw IllegalAccessException("ViewModel class not found")
    }
}