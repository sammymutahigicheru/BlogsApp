package com.droid.diexample.data.remote.api

import com.droid.diexample.data.remote.model.BlogNetworkEntity
import retrofit2.http.GET

interface BlogApiService {

    @GET("blogs")
    suspend fun get(): List<BlogNetworkEntity>
}



