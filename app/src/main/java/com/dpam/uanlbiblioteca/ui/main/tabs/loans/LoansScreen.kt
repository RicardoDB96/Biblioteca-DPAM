package com.dpam.uanlbiblioteca.ui.main.tabs.loans

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.composables.core.DragIndication
import com.composables.core.ModalBottomSheet
import com.composables.core.Scrim
import com.composables.core.Sheet
import com.composables.core.SheetDetent.Companion.FullyExpanded
import com.composables.core.SheetDetent.Companion.Hidden
import com.composables.core.rememberModalBottomSheetState
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

    val sheetState = rememberModalBottomSheetState(
        initialDetent = Hidden,
    )

    ScreenLayout(topBar = { TopAppBar(title = context.getString(R.string.loans)) }) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (state.loans.isEmpty()) {
                EmptyLoans()
            } else {
                LoansList(
                    loans = state.loans,
                    onLoanClick = { loanId ->
                        vm.onLoanClick(loanId)
                        sheetState.currentDetent = FullyExpanded
                    },
                    books = state.books
                )
            }
        }

        ModalBottomSheet(state = sheetState) {
            Scrim()
            Sheet(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f),
                    contentAlignment = Alignment.TopCenter
                ) {
                    DragIndication(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .background(
                                Color.Black.copy(0.4f),
                                RoundedCornerShape(100)
                            )
                            .width(32.dp)
                            .height(4.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Estado del préstamo",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Regresar el libro",
                            textAlign = TextAlign.Center
                        )
                        Button(onClick = {
                            vm.onLoanReturn()
                            sheetState.currentDetent = Hidden
                        }, modifier = Modifier.fillMaxWidth()) {
                            Text(text = "Entregar libro")
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Renovación del préstamo",
                            textAlign = TextAlign.Center
                        )
                        Row {
                            val selectionTime = listOf("7 dias", "14 dias")
                            selectionTime.forEach { time ->
                                Row(
                                    Modifier
                                        .weight(1f)
                                        .height(56.dp)
                                        .selectable(
                                            selected = (selectionTime.indexOf(time) == state.selectedTime),
                                            onClick = {
                                                vm.onLoanSelection(
                                                    selectedTime = selectionTime.indexOf(time)
                                                )
                                            },
                                            role = Role.RadioButton
                                        )
                                        .padding(horizontal = 16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = (selectionTime.indexOf(time) == state.selectedTime),
                                        onClick = null
                                    )
                                    Text(
                                        text = time,
                                        modifier = Modifier.padding(start = 16.dp)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            TextButton(
                                onClick = {
                                    vm.onLoanCancel()
                                    sheetState.currentDetent = Hidden
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(text = "Cancelar")
                            }
                            Spacer(modifier = Modifier.weight(2f))
                            if (state.isRenovateEnabled) {
                                TextButton(
                                    onClick = {
                                        vm.onLoanRenew()
                                        sheetState.currentDetent = Hidden
                                    },
                                ) {
                                    Text(text = "Realizar renovacion")
                                }
                            }
                        }
                    }
                }
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
fun LoansList(loans: List<LoanEntity>, onLoanClick: (Long) -> Unit, books: List<BookWithDetails?>) {
    LazyColumn {
        items(loans) {
            LoanItem(loan = it, onLoanClick = { id -> onLoanClick(id) }, books = books)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoanItem(
    loan: LoanEntity,
    modifier: Modifier = Modifier,
    onLoanClick: (Long) -> Unit,
    books: List<BookWithDetails?>
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = { onLoanClick(loan.id) },
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
