package com.dpam.uanlbiblioteca.ui.main

import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dpam.uanlbiblioteca.ui.core.navigation.navigationbar.NavigationBarWrapper
import com.dpam.uanlbiblioteca.ui.core.navigation.navigationbar.NavigationItem

@Composable
fun MainScreen(mainNavController: NavHostController, navController: NavHostController) {
    val items = listOf(
        NavigationItem.Catalog(),
        NavigationItem.Loans(),
        NavigationItem.Libraries(),
        NavigationItem.Profile(),
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavigationSuiteScaffold(navigationSuiteItems = {
        navigationBar(
            items = items,
            navController = navController,
            navBackStackEntry = navBackStackEntry
        )
    }) {
        NavigationBarWrapper(navController = navController, mainNavController = mainNavController)
    }
}

fun NavigationSuiteScope.navigationBar(
    items: List<NavigationItem>,
    navController: NavHostController,
    navBackStackEntry: NavBackStackEntry?
) {
    val currentDestination = navBackStackEntry?.destination

    items.forEach { item ->
        item(
            icon = item.icon,
            label = { Text(item.title()) },
            onClick = {
                navController.navigate(route = item.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
            alwaysShowLabel = false,
        )
    }
}