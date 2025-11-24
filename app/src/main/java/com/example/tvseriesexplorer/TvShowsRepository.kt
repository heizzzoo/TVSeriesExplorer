package com.example.tvseriesexplorer.data

import com.example.tvseriesexplorer.data.remote.EpisodateApi
import com.example.tvseriesexplorer.model.TvShow
import com.example.tvseriesexplorer.model.TvShowDetails
import javax.inject.Inject

class TvShowsRepository @Inject constructor(
    private val api: EpisodateApi
) {

    suspend fun getPopularShows(page: Int = 1): List<TvShow> {
        val response = api.getMostPopular(page)
        return response.tv_shows.map {
            TvShow(
                id = it.id,
                name = it.name,
                imageUrl = it.image_thumbnail_path,
                network = it.network
            )
        }
    }

    suspend fun searchShows(query: String, page: Int = 1): List<TvShow> {
        val response = api.searchShows(query, page)
        return response.tv_shows.map {
            TvShow(
                id = it.id,
                name = it.name,
                imageUrl = it.image_thumbnail_path,
                network = it.network
            )
        }
    }

    suspend fun getShowDetails(idOrPermalink: String): TvShowDetails {
        val response = api.getShowDetails(idOrPermalink)
        val show = response.tvShow
        return TvShowDetails(
            id = show.id,
            name = show.name,
            imageUrl = show.image_path,
            description = show.description,
            rating = show.rating,
            episodesCount = show.episodes.size
        )
    }
}
