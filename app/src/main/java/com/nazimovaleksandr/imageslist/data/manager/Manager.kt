package com.nazimovaleksandr.imageslist.data.manager

import com.nazimovaleksandr.imageslist.data.DataContract
import com.nazimovaleksandr.imageslist.data.api.Api

class Manager(private val api: Api) : DataContract.Manager {

    fun getImagesList(callback: (List<String>) -> Unit) {
        api.loadImages {
            callback(it)
        }
    }
}