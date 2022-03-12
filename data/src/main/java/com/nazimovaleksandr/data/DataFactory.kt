package com.nazimovaleksandr.data

import com.nazimovaleksandr.data.api.Api
import com.nazimovaleksandr.data.manager.Manager

object DataFactory {
    private var INSTANSE: DataContract.Manager? = null

    private const val BASE_URL = "https://dev-tasks.alef.im"

    fun getManager(): DataContract.Manager = INSTANSE ?: synchronized(this) {
        val manager = Manager(
            Api(BASE_URL)
        )

        INSTANSE = manager

        manager
    }
}