package com.dpam.uanlbiblioteca.ui.core.navigation.navigationbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.dpam.uanlbiblioteca.R
import com.dpam.uanlbiblioteca.ui.core.navigation.Routes

sealed class NavigationItem {
    abstract val route: String
    abstract val title: @Composable () -> String // Title is now a composable function
    abstract val icon: @Composable () -> Unit

    data class Home(
        override val route: String = Routes.Home.route,
        override val title: @Composable () -> String = {
            LocalContext.current.getString(R.string.home)
        },
        override val icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.Home, contentDescription = title())
        },
    ) : NavigationItem()

    data class Catalog(
        override val route: String = Routes.Catalog.route,
        override val title: @Composable () -> String = {
            LocalContext.current.getString(R.string.catalog)
        },
        override val icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.Book, contentDescription = title())
        },
    ) : NavigationItem()

    data class Loans(
        override val route: String = Routes.Loans.route,
        override val title: @Composable () -> String = {
            LocalContext.current.getString(R.string.loans)
        },
        override val icon: @Composable () -> Unit = {
            Icon(painter = painterResource(id = R.drawable.ic_loans), contentDescription = title())
        },
    ) : NavigationItem()

    data class Libraries(
        override val route: String = Routes.Libraries.route,
        override val title: @Composable () -> String = {
            LocalContext.current.getString(R.string.libraries)
        },
        override val icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.AutoMirrored.Filled.MenuBook, contentDescription = title())
        },
    ) : NavigationItem()

    data class Profile(
        override val route: String = Routes.Profile.route,
        override val title: @Composable () -> String = {
            LocalContext.current.getString(R.string.profile)
        },
        override val icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = title())
        },
    ) : NavigationItem()
}