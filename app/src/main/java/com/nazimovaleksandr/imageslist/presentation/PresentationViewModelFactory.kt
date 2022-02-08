package com.nazimovaleksandr.imageslist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nazimovaleksandr.imageslist.data.DataFactory
import com.nazimovaleksandr.imageslist.domain.DomainContract
import com.nazimovaleksandr.imageslist.domain.GetImagesList
import com.nazimovaleksandr.imageslist.presentation.images_list.ImagesViewModel

class PresentationViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImagesViewModel::class.java)) {
            val manager = DataFactory.getManager()
            val getImagesList: DomainContract.GetImagesListUseCase = GetImagesList(manager)

            return ImagesViewModel(getImagesList) as T
        }

        throw IllegalAccessException("ViewModel class not found")
    }
}