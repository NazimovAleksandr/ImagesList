package com.nazimovaleksandr.imageslist.presentation.screens.image

import android.os.Bundle
import coil.load
import com.nazimovaleksandr.imageslist.R
import com.nazimovaleksandr.imageslist.databinding.FragmentImageBinding
import com.nazimovaleksandr.imageslist.presentation.constants.BUNDLE_KEY_IMAGE_PATH
import com.nazimovaleksandr.imageslist.presentation.screens.factory.BindingFactory

class ImageFragment : BindingFactory<FragmentImageBinding>(
    FragmentImageBinding::inflate
) {

    override fun viewBindingCreated(savedInstanceState: Bundle?) {
        initView()
        initListeners()
    }

    private fun initView() {
        val imagePath = arguments?.getString(BUNDLE_KEY_IMAGE_PATH)

        binding.image.load(imagePath) {
            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_foreground)
        }
    }

    private fun initListeners() {
        binding.root.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}