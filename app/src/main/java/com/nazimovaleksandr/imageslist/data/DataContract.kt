package com.nazimovaleksandr.imageslist.data

interface DataContract {
    interface Manager {
        fun getImagesList(callback: (List<String>) -> Unit)
    }
}