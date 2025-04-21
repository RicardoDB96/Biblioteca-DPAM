package com.dpam.uanlbiblioteca.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dpam.uanlbiblioteca.ui.book_detail.BookDetailScreen
import com.dpam.uanlbiblioteca.ui.main.MainScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()
    val navController = rememberNavController()

    NavHost(navController = mainNavController, startDestination = Routes.Main) {
        composable<Routes.Main> {
            MainScreen(mainNavController = mainNavController, navController = navController)
        }
        composable<Routes.BookDetail> { navBackStackEntry ->
            val bookId = navBackStackEntry.toRoute<Routes.BookDetail>().id

            BookDetailScreen(
                vm = koinViewModel(parameters = { parametersOf(bookId) }),
                onBackClick = {
                mainNavController.popBackStack(
                    route = Routes.Main,
                    inclusive = false
                )
            })
        }
    }
}