package com.dpam.uanlbiblioteca.ui.core.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScreenLayout(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    content: @Composable (ColumnScope.() -> Unit),
) {
    Scaffold(topBar = topBar) {
        Column(modifier = modifier.padding(it), content = content)
    }
}