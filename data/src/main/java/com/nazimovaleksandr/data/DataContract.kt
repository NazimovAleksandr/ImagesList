package com.nazimovaleksandr.data

interface DataContract {
    interface Manager {
        fun getImagesList(callback: (List<String>) -> Unit)
    }
}