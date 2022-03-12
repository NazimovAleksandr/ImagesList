package com.nazimovaleksandr.data.manager

import com.nazimovaleksandr.data.DataContract
import com.nazimovaleksandr.data.api.Api

class Manager(private val api: Api) : DataContract.Manager {

    override fun getImagesList(callback: (List<String>) -> Unit) {
        api.loadImages {
            callback(it)
        }
    }
}