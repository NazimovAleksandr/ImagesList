package com.nazimovaleksandr.imageslist.di

import com.nazimovaleksandr.data.DataContract
import com.nazimovaleksandr.data.api.Api
import com.nazimovaleksandr.data.manager.Manager
import org.koin.dsl.module

private const val BASE_URL = "https://dev-tasks.alef.im"

val dataModule = module {
    single {
        Api(url = BASE_URL)
    }

    single<DataContract.Manager> {
        Manager(api = get())
    }
}