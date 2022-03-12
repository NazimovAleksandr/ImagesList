package com.nazimovaleksandr.data.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val HTTP = "http://"
const val HTTPS = "https://"

class Api(url: String) : Callback<List<String>> {
    private var retrofit: Retrofit? = null
    private var service: ApiService? = null

    private var callback: (List<String>) -> Unit = {}

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit?.create(ApiService::class.java)
    }

    fun loadImages(callback: (List<String>) -> Unit) {
        this.callback = callback
        service?.getImages()?.enqueue(this)
    }

    override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
        response.body()?.let {
            callback(it.map { path ->
                path.replace(HTTP, HTTPS)
            })
        }
    }

    override fun onFailure(call: Call<List<String>>, t: Throwable) {
        callback(emptyList())
    }
}