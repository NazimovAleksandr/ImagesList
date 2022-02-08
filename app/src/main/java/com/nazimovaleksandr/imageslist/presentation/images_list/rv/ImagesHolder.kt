package com.nazimovaleksandr.imageslist.presentation.images_list.rv

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nazimovaleksandr.imageslist.R


class ImagesHolder(
    itemView: View,
    private val imageOnClick: (String) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bind(path: String) {
        val imageview = itemView.findViewById<ImageView>(R.id.image)

        Glide.with(itemView).load(path).into(imageview)

        itemView.setOnClickListener {
            imageOnClick(path)
        }
    }
}