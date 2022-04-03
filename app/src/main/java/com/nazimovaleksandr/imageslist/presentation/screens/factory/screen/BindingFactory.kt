package com.nazimovaleksandr.imageslist.presentation.screens.factory.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.nazimovaleksandr.imageslist.di.AppComponent
import com.nazimovaleksandr.imageslist.presentation.app.App
import com.nazimovaleksandr.imageslist.presentation.screens.images_list.ImagesListFragment

abstract class BindingFactory<VB : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    private var _appComponent: AppComponent? = null
    protected val appComponent get() = _appComponent!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _appComponent = (requireActivity().applicationContext as App).appComponent

        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBindingCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _appComponent = null
        _binding = null
    }

    abstract fun viewBindingCreated(savedInstanceState: Bundle?)
}