package com.nazimovaleksandr.imageslist.presentation.screens.images_list.rv

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazimovaleksandr.imageslist.databinding.RvImageItemBinding

class ImagesAdapter(
    private var imageList: List<String>,
    private val imageOnClick: (String) -> Unit
) : RecyclerView.Adapter<ImagesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvImageItemBinding.inflate(inflater, parent, false)

        return ImagesHolder(binding, imageOnClick)
    }

    override fun onBindViewHolder(holder: ImagesHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setImageList(imageList: List<String>) {
        this.imageList = imageList
        notifyDataSetChanged()
    }
}