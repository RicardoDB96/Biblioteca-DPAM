package com.dpam.uanlbiblioteca.ui.main.tabs.libraries

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.dpam.uanlbiblioteca.R
import com.dpam.uanlbiblioteca.ui.core.componets.ScreenLayout
import com.dpam.uanlbiblioteca.ui.core.componets.TopAppBar

@Composable
fun LibrariesScreen() {
    val context = LocalContext.current

    ScreenLayout(topBar = { TopAppBar(title = context.getString(R.string.libraries)) }) {
    }
}