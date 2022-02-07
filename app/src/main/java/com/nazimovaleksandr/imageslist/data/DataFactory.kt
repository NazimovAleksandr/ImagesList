package com.nazimovaleksandr.imageslist.data

import com.nazimovaleksandr.imageslist.constants.BASE_URL
import com.nazimovaleksandr.imageslist.data.api.Api
import com.nazimovaleksandr.imageslist.data.manager.Manager

object DataFactory {
    private var INSTANSE: Manager? = null

    fun getManager(): Manager = INSTANSE ?: synchronized(this) {
        val manager = Manager(
            Api(BASE_URL)
        )

        INSTANSE = manager

        manager
    }
}