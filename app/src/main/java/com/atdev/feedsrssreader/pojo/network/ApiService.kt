package com.atdev.feedsrssreader.pojo.network

import com.atdev.feedsrssreader.pojo.models.RootObject
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api.json")
    suspend fun getItems(@Query("rss_url") rssUrl: String): RootObject
}