package com.dpam.uanlbiblioteca.ui.main.tabs.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dpam.uanlbiblioteca.R
import com.dpam.uanlbiblioteca.ui.core.componets.ScreenLayout
import com.dpam.uanlbiblioteca.ui.core.componets.TopAppBar
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileScreen(vm: ProfileViewModel = koinViewModel(), onSettingsClick: () -> Unit) {
    val context = LocalContext.current
    val state by vm.state.collectAsState()

    ScreenLayout(topBar = {
        TopAppBar(
            title = context.getString(R.string.profile),
            actions = {
                IconButton(onClick = onSettingsClick) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = context.getString(R.string.settings)
                    )
                }
            })
    }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CoilImage(
                imageModel = { state.student.profileURL },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .size(250.dp)
                    .aspectRatio(ratio = 1f)
                    .clip(CircleShape)
            )
            Text(
                text = state.student.name,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Column(
                    modifier = Modifier.padding(8.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    CoilImage(
                        imageModel = { "https://arquitectura.uanl.mx/wp-content/uploads/2022/01/Uanl-color-blanco.png" },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.Center
                        ),
                        modifier = Modifier
                            .padding(16.dp)
                            .height(75.dp)
                            .aspectRatio(ratio = 2/1f)
                    )

                    Row {
                        Text(text = "Facultad: ", fontWeight = FontWeight.Bold)
                        Text(text = state.student.campus)
                    }
                    Row {
                        Text(text = "Carrera: ", fontWeight = FontWeight.Bold)
                        Text(text = state.student.major)
                    }
                    Row {
                        Text(text = "Matricula: ", fontWeight = FontWeight.Bold)
                        Text(text = state.student.enrollmentNumber)
                    }
                }
            }
        }
    }
}