package com.nazimovaleksandr.imageslist.presentation.screens.images_list.rv

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.nazimovaleksandr.imageslist.R
import com.nazimovaleksandr.imageslist.databinding.RvImageItemBinding

class ImagesHolder(
    private val binding: RvImageItemBinding,
    private val imageOnClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(path: String) {
        binding.image.load(path) {
            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_foreground)
            transformations(CircleCropTransformation())
        }

        itemView.setOnClickListener {
            imageOnClick(path)
        }
    }
}