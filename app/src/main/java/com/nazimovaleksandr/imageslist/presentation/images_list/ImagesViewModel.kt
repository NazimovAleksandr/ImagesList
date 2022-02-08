package com.nazimovaleksandr.imageslist.presentation.images_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazimovaleksandr.imageslist.domain.DomainContract

class ImagesViewModel(
   private val getImagesList: DomainContract.GetImagesListUseCase
) : ViewModel() {

    val imagesList: LiveData<List<String>> by lazy { MutableLiveData() }

    init {
        getImagesList.invoke {
            (imagesList as MutableLiveData).value = it

            it.forEach { url ->
                Log.i("retrofit", "body: $url")
            }
        }
    }

    fun loadImagesList() {
        getImagesList.invoke {
            (imagesList as MutableLiveData).value = it

            it.forEach { url ->
                Log.i("retrofit", "body: $url")
            }
        }
    }
}