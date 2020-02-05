package com.atdev.feedsrssreader.pojo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    const val BASE_URL = "https://api.rss2json.com/v1/"

    val retrofitBuilder: Retrofit.Builder by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }


    val apiService: ApiService by lazy {

        retrofitBuilder.build()
            .create(ApiService::class.java)
    }
}