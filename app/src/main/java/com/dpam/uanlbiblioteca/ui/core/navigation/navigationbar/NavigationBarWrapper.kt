package com.dpam.uanlbiblioteca.ui.core.navigation.navigationbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dpam.uanlbiblioteca.ui.core.navigation.Routes
import com.dpam.uanlbiblioteca.ui.main.tabs.home.HomeScreen
import com.dpam.uanlbiblioteca.ui.main.tabs.settings.SettingsScreen

@Composable
fun NavigationBarWrapper(navController: NavHostController, mainNavController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            HomeScreen()
        }
        composable(route = Routes.Settings.route) {
            SettingsScreen()
        }
    }
}