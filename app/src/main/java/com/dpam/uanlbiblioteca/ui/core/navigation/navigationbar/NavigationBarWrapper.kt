package com.dpam.uanlbiblioteca.ui.core.navigation.navigationbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dpam.uanlbiblioteca.ui.core.navigation.Routes
import com.dpam.uanlbiblioteca.ui.main.tabs.catalog.CatalogScreen
import com.dpam.uanlbiblioteca.ui.main.tabs.home.HomeScreen
import com.dpam.uanlbiblioteca.ui.main.tabs.libraries.LibrariesScreen
import com.dpam.uanlbiblioteca.ui.main.tabs.loans.LoansScreen
import com.dpam.uanlbiblioteca.ui.main.tabs.profile.ProfileScreen

@Composable
fun NavigationBarWrapper(navController: NavHostController, mainNavController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            HomeScreen()
        }
        composable(route = Routes.Catalog.route) {
            CatalogScreen(onBookClick = { id -> mainNavController.navigate(Routes.BookDetail(id)) })
        }
        composable(route = Routes.Loans.route) {
            LoansScreen()
        }
        composable(route = Routes.Libraries.route) {
            LibrariesScreen()
        }
        composable(route = Routes.Profile.route) {
            ProfileScreen()
        }
    }
}