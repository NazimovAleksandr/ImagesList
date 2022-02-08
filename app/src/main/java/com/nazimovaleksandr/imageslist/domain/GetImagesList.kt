package com.nazimovaleksandr.imageslist.domain

import com.nazimovaleksandr.imageslist.data.DataContract

class GetImagesList(
    private val manager: DataContract.Manager
) : DomainContract.GetImagesListUseCase {

    override fun invoke(callback: (List<String>) -> Unit) {
        manager.getImagesList { callback(it) }
    }
}