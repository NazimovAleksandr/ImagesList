package com.nazimovaleksandr.imageslist.data.api

import com.nazimovaleksandr.imageslist.constants.IMAGES_URL
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(IMAGES_URL)
    fun getImages(): Call<List<String>>
}