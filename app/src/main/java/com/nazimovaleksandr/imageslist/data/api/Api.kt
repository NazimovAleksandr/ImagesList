package com.nazimovaleksandr.imageslist.data.api

import android.util.Log
import com.nazimovaleksandr.imageslist.constants.HTTP
import com.nazimovaleksandr.imageslist.constants.HTTPS
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        Log.e("retrofit", "onResponse: $response")

        response.body()?.let {
            callback(it.map { path ->
                path.replace(HTTP, HTTPS)
            })

            it.forEach { url ->
                Log.i("retrofit2", "body: $url")
            }
        }
    }

    override fun onFailure(call: Call<List<String>>, t: Throwable) {
        Log.e("retrofit", "onFailure: ${t.message}")

        callback(emptyList())
    }
}