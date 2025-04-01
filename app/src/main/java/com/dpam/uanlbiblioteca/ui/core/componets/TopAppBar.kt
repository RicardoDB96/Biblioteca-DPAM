package com.dpam.uanlbiblioteca.ui.core.componets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.dpam.uanlbiblioteca.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    title: String,
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(modifier = modifier, title = { Text(text = title) }, navigationIcon = {
        if (onBackClick != null) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = LocalContext.current.getString(R.string.back)
                )
            }
        }
    }, actions = actions)
}