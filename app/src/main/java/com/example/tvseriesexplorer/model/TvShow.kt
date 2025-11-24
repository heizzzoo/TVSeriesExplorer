package com.example.tvseriesexplorer.model

// Modèle simplifié pour les listes (Home / Recherche)
data class TvShow(
    val id: Int,
    val name: String,
    val imageUrl: String?,
    val network: String?
)

// Modèle pour la page de détails
data class TvShowDetails(
    val id: Int,
    val name: String,
    val imageUrl: String?,
    val description: String?,
    val rating: String?,
    val episodesCount: Int
)
