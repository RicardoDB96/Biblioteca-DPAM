package com.dpam.uanlbiblioteca.ui.main.tabs.libraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dpam.uanlbiblioteca.R
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity
import com.dpam.uanlbiblioteca.ui.core.componets.ScreenLayout
import com.dpam.uanlbiblioteca.ui.core.componets.TopAppBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LibrariesScreen(vm: LibrariesViewModel = koinViewModel()) {
    val context = LocalContext.current
    val state by vm.state.collectAsState()

    ScreenLayout(topBar = { TopAppBar(title = context.getString(R.string.libraries)) }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(items = state.libraries, key = { it.id }) {
                LibraryCard(library = it)
            }
        }
    }
}

@Composable
fun LibraryCard(modifier: Modifier = Modifier, library: LibraryEntity) {
    Card(modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            TextWithBold(boldText = "Nombre: ", normalText = library.name)
            TextWithBold(boldText = "Ubicación: ", normalText = library.location)
            TextWithBold(boldText = "Horario: ", normalText = library.hours ?: "No disponible")
            TextWithBold(
                boldText = "Información de contacto: ",
                normalText = library.contactInfo ?: "No disponible"
            )
            TextWithBold(boldText = "Campus: ", normalText = library.campusId.toString())
        }
    }
}

@Composable
fun TextWithBold(modifier: Modifier = Modifier, boldText: String, normalText: String) {
    Row(modifier = modifier) {
        Text(text = boldText, fontWeight = FontWeight.Bold)
        Text(text = normalText)
    }
}