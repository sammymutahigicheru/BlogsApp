package com.droid.diexample.domain.repository

import com.droid.diexample.domain.BlogDomain
import kotlinx.coroutines.flow.Flow

interface IBlogsRepository {
    suspend fun getBlogs(): Flow<List<BlogDomain>>
}