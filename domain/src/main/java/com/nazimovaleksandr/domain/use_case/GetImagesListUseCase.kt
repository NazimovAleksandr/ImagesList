package com.nazimovaleksandr.domain.use_case

import com.nazimovaleksandr.data.DataContract
import com.nazimovaleksandr.domain.DomainContract

class GetImagesListUseCase(
    private val manager: DataContract.Manager
) : DomainContract.GetImagesListUseCase {

    override fun invoke(callback: (List<String>) -> Unit) {
        manager.getImagesList { callback(it) }
    }
}