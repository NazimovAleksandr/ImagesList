package com.nazimovaleksandr.imageslist.domain

interface DomainContract {
    interface GetImagesListUseCase { fun invoke(callback: (List<String>) -> Unit) }
}