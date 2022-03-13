package com.nazimovaleksandr.imageslist.presentation.screens.images_list

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nazimovaleksandr.domain.DomainContract
import com.nazimovaleksandr.imageslist.di.Prod
import javax.inject.Inject

class ImagesViewModelFactory @Inject constructor(
    @Prod
    private val getImagesListUseCase: DomainContract.GetImagesListUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImagesViewModel::class.java)) {
            return ImagesViewModel(getImagesListUseCase) as T
        }

        throw IllegalAccessException("ViewModel class not found")
    }

    @Inject
    fun viewModelFactoryCreated(context: Context) {
        Toast.makeText(context, "viewModelFactoryCreated", Toast.LENGTH_SHORT).show()
    }
}