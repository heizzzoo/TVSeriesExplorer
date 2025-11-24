package com.example.tvseriesexplorer.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodateApi {

    // /most-popular?page=1
    @GET("most-popular")
    suspend fun getMostPopular(
        @Query("page") page: Int = 1
    ): MostPopularResponse

    // /search?q=query&page=1
    @GET("search")
    suspend fun searchShows(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): MostPopularResponse

    // /show-details?q=ID
    @GET("show-details")
    suspend fun getShowDetails(
        @Query("q") showIdOrPermalink: String
    ): ShowDetailsResponse
}
