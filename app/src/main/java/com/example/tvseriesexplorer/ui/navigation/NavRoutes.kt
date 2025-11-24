package com.example.tvseriesexplorer.ui.navigation

object NavRoutes {
    const val HOME = "home"
    const val DETAILS = "details/{showId}"

    fun details(showId: Int) = "details/$showId"
}
