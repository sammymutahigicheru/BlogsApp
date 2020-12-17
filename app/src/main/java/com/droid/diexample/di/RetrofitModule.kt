package com.droid.diexample.di

import com.droid.diexample.data.remote.api.BlogApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
   fun provideGsonBulder(): Gson{
       return  GsonBuilder()
           .excludeFieldsWithoutExposeAnnotation()
           .create()
   }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun  provideBlogService(retrofit: Retrofit.Builder): BlogApiService {
        return retrofit
            .build()
            .create(BlogApiService::class.java)
    }
}