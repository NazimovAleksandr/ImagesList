package com.nazimovaleksandr.imageslist.presentation.screens.images_list.rv

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nazimovaleksandr.imageslist.R

class ImagesHolder(
    itemView: View,
    private val imageOnClick: (String) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bind(path: String) {
        val imageView = itemView.findViewById<ImageView>(R.id.image)

        imageView.load(path) {
            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_foreground)
        }

        itemView.setOnClickListener {
            imageOnClick(path)
        }
    }
}