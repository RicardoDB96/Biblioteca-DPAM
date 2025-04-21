package com.dpam.uanlbiblioteca.ui.book_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dpam.uanlbiblioteca.domain.model.BookModel

@Composable
fun BookInformation(modifier: Modifier = Modifier, book: BookModel) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = book.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "por ${book.author}",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Row {
                Text(text = "ISBN: ", fontWeight = FontWeight.Bold)
                Text(text = book.isbn ?: "No disponible")
            }
        }
    }
}