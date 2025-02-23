package com.dpam.uanlbiblioteca.ui.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {
    @Serializable
    data object Main

    @Serializable
    data object Home: Routes(route = "home")

    @Serializable
    data object Settings: Routes(route = "settings")
}
