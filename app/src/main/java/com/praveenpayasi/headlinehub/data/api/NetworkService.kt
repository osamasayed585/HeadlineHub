package com.praveenpayasi.headlinehub.data.api

import com.praveenpayasi.headlinehub.data.model.newssource.NewsSourcesResponse
import com.praveenpayasi.headlinehub.data.model.topheadlines.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String, @Query("page") page: Int = 1, @Query("pageSize") pageSize: Int = 20): TopHeadlinesResponse

    @GET("top-headlines/sources")
    suspend fun getNewsSources(): NewsSourcesResponse

    @GET("top-headlines")
    suspend fun getNewsBySources(@Query("sources") sources: String): TopHeadlinesResponse

    @GET("top-headlines")
    suspend fun getNewsByCountry(@Query("country") country: String): TopHeadlinesResponse

    @GET("top-headlines")
    suspend fun getNewsByLanguage(@Query("language") language: String): TopHeadlinesResponse

}