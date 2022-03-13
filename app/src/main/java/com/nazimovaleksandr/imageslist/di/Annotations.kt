package com.nazimovaleksandr.imageslist.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Prod

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dev