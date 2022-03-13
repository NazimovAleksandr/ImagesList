package com.nazimovaleksandr.imageslist.di

import com.nazimovaleksandr.data.DataContract
import com.nazimovaleksandr.data.api.Api
import com.nazimovaleksandr.data.manager.Manager
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    private val baseUrlProd = "https://dev-tasks.alef.im"
    private val baseUrlDev = "https://dev-tasks.alef.im-"

    @Prod
    @Provides
//    @Singleton
    fun provideApiProd(): Api {
        return Api(baseUrlProd)
    }

    @Dev
    @Provides
//    @Singleton
    fun provideApiDev(): Api {
        return Api(baseUrlDev)
    }

    @Prod
    @Provides
//    @Singleton
    fun provideDataManagerProd(
        @Prod
        api: Api
    ): DataContract.Manager {
        return Manager(api)
    }

    @Dev
    @Provides
//    @Singleton
    fun provideDataManagerDev(
        @Dev
        api: Api
    ): DataContract.Manager {
        return Manager(api)
    }
}