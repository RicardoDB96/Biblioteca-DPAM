package com.dpam.uanlbiblioteca.ui.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {
    @Serializable
    data object Main

    @Serializable
    data object Home: Routes(route = "home")

    @Serializable
    data object Catalog: Routes(route = "catalog")

    @Serializable
    data object Loans: Routes(route = "loans")

    @Serializable
    data object Libraries: Routes(route = "libraries")

    @Serializable
    data object Profile: Routes(route = "profile")
}
