package com.dpam.uanlbiblioteca.ui.main.tabs.loans

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dpam.uanlbiblioteca.R
import com.dpam.uanlbiblioteca.data.database.entity.BookWithDetails
import com.dpam.uanlbiblioteca.data.database.entity.LoanEntity
import com.dpam.uanlbiblioteca.ui.core.componets.ScreenLayout
import com.dpam.uanlbiblioteca.ui.core.componets.TopAppBar
import org.koin.compose.viewmodel.koinViewModel
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoansScreen(vm: LoansViewModel = koinViewModel()) {
    val context = LocalContext.current
    val state by vm.uiState.collectAsState()

    ScreenLayout(topBar = { TopAppBar(title = context.getString(R.string.loans)) }) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (state.loans.isEmpty()) {
                EmptyLoans()
            } else {
                LoansList(loans = state.loans, books = state.books)
            }
        }
    }
}

@Composable
fun EmptyLoans() {
    Text(
        text = "No hay prestamos registrados",
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoansList(loans: List<LoanEntity>, books: List<BookWithDetails?>) {
    LazyColumn {
        items(loans) {
            LoanItem(loan = it, books = books)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoanItem(loan: LoanEntity, modifier: Modifier = Modifier, books: List<BookWithDetails?>) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            loan.bookId?.let { bookId ->
                Text(
                    text = "Libro: ${books.find { it?.book?.id == bookId }?.book?.title ?: ""}",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            loan.loanDate?.let {
                Text(text = "Fecha de préstamo: ${it.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}")
            }

            loan.dueDate?.let {
                Text(text = "Fecha de vencimiento: ${it.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}")
            }

            loan.returnDate?.let {
                Text(
                    text = "Fecha de devolución: ${it.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}",
                    color = Color.Gray
                )
            } ?: Text(
                text = "Aún no devuelto",
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )

            loan.status?.let {
                Text(text = "Estado: $it")
            }
        }
    }
}
