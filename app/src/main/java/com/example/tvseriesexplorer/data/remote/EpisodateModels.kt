package com.example.tvseriesexplorer.data.remote

// Réponse pour /most-popular et /search
data class MostPopularResponse(
    val total: Int,
    val page: Int,
    val pages: Int,
    val tv_shows: List<TvShowRemote>
)

// Série dans la liste
data class TvShowRemote(
    val id: Int,
    val name: String,
    val permalink: String,
    val start_date: String?,
    val end_date: String?,
    val country: String?,
    val network: String?,
    val status: String?,
    val image_thumbnail_path: String?
)

// Réponse pour /show-details
data class ShowDetailsResponse(
    val tvShow: TvShowDetailsRemote
)

// Détails d'une série
data class TvShowDetailsRemote(
    val id: Int,
    val name: String,
    val permalink: String,
    val description: String?,
    val rating: String?,
    val image_path: String?,
    val episodes: List<EpisodeRemote>
)

// Un épisode (on ne l'utilisera que pour compter)
data class EpisodeRemote(
    val season: Int,
    val episode: Int,
    val name: String
)
