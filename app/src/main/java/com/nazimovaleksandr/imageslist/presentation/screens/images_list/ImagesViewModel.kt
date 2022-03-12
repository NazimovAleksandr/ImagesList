package com.nazimovaleksandr.imageslist.presentation.screens.images_list

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazimovaleksandr.domain.DomainContract
import com.nazimovaleksandr.imageslist.presentation.utils.delay
import com.nazimovaleksandr.imageslist.presentation.utils.isInternetAvailable
import kotlinx.coroutines.Job

class ImagesViewModel(
    private val getImagesList: DomainContract.GetImagesListUseCase
) : ViewModel() {

    val imagesList: LiveData<List<String>> by lazy { MutableLiveData() }
    val isInternetAvailable: LiveData<Boolean> by lazy { MutableLiveData() }

    private var loader: Job? = null

    fun getImagesList(context: Context) {
        if (isInternetAvailable(context = context)) {
            loadImagesList()
        } else {
            (isInternetAvailable as MutableLiveData).value = false

            loader?.cancel()
            loader = delay(
                viewModelScope
            ) {
                if (isInternetAvailable(context = context)) {
                    loadImagesList()
                    loader?.cancel()
                    loader = null
                }
            }
        }
    }

    private fun loadImagesList() {
        getImagesList.invoke {
            (imagesList as MutableLiveData).value = it

            it.forEach { url ->
                Log.i("retrofit", "body: $url")
            }
        }
    }
}