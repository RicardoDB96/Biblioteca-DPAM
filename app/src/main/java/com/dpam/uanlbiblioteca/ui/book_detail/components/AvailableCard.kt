package com.dpam.uanlbiblioteca.ui.book_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity

@Composable
fun AvailableCard(
    modifier: Modifier = Modifier,
    campusId: Long,
    libraries: List<LibraryEntity>,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            if (campusId in libraries.map { it.campusId }) {
                Text(text = "Disponible en tu campus", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
            }
            if (libraries.isNotEmpty()) {
                Text(
                    text = "Disponibilidad en las siguientes bibliotecas:",
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(libraries) { library ->
                        OutlinedCard {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text(text = library.name)
                            }
                        }
                    }
                }
            } else {
                Text(text = "No hay disponibilidad en las bibliotecas")
            }
        }
    }
}