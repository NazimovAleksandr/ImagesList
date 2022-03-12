package com.nazimovaleksandr.domain

interface DomainContract {
    interface GetImagesListUseCase { fun invoke(callback: (List<String>) -> Unit) }
}