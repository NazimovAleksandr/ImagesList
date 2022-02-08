package com.nazimovaleksandr.imageslist.presentation.image

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.nazimovaleksandr.imageslist.R
import com.nazimovaleksandr.imageslist.constants.BUNDLE_KEY_IMAGE_PATH

class ImageFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NO_TITLE, androidx.appcompat.R.style.Base_Theme_AppCompat_Dialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.image)
        val imagePath = arguments?.getString(BUNDLE_KEY_IMAGE_PATH)

        Log.e("imageFragment", "imagePath: $imagePath")
        Log.e("imageFragment", "imageView: $imageView")

        Glide.with(requireContext())
            .load(imagePath)
            .into(imageView)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }
}