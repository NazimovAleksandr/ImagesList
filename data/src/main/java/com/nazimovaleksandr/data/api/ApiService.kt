package com.nazimovaleksandr.data.api

import retrofit2.Call
import retrofit2.http.GET

const val IMAGES_URL = "/task-m-001/list.php"

interface ApiService {
    @GET(IMAGES_URL)
    fun getImages(): Call<List<String>>
}