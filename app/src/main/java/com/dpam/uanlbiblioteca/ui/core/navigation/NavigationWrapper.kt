package com.dpam.uanlbiblioteca.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dpam.uanlbiblioteca.ui.main.MainScreen

@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()

    NavHost(navController = mainNavController, startDestination = Routes.Main) {
        composable<Routes.Main> {
            MainScreen(mainNavController = mainNavController)
        }
    }
}