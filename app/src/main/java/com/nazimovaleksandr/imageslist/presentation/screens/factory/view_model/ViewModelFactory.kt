package com.nazimovaleksandr.imageslist.presentation.screens.factory.view_model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val viewModelProviders: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return viewModelProviders[modelClass]?.get() as T
            ?: throw IllegalArgumentException("ViewModel class not found")
    }

    @Inject
    fun viewModelFactoryCreated(context: Context) {
        Toast.makeText(context, "ViewModelFactory Created", Toast.LENGTH_SHORT).show()
    }
}