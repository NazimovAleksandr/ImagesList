package com.nazimovaleksandr.imageslist.di

import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Prod

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dev

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope