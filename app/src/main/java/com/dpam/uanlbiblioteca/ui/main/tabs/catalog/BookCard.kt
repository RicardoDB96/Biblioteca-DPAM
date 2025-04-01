package com.dpam.uanlbiblioteca.ui.main.tabs.catalog

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.dpam.uanlbiblioteca.domain.model.BookModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage

@Composable
fun BookCard(modifier: Modifier = Modifier, book: BookModel, onClick: () -> Unit) {
    Card(modifier = modifier.padding(4.dp), shape = RoundedCornerShape(10.dp)) {
        Box(modifier = Modifier.clickable(onClick = onClick)) {
            CoilImage(
                imageModel = { book.imageUrl },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                ),
                modifier = Modifier.aspectRatio(ratio = 2 / 3f)
            )
            Text(
                text = book.title,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 4.dp)
                    .basicMarquee(iterations = Int.MAX_VALUE), // Marquee effect forever
                maxLines = 1,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color.White,
                    shadow = Shadow(
                        color = Color.Black,
                        blurRadius = 6f,
                    ),
                ),
            )
        }
    }
}