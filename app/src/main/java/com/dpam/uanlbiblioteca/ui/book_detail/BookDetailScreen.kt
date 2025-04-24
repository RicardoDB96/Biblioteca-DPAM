package com.dpam.uanlbiblioteca.ui.book_detail

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
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
import com.dpam.uanlbiblioteca.data.database.entity.LibraryEntity
import com.dpam.uanlbiblioteca.ui.book_detail.components.AvailableCard
import com.dpam.uanlbiblioteca.ui.book_detail.components.BookCard
import com.dpam.uanlbiblioteca.ui.book_detail.components.BookInformation
import com.dpam.uanlbiblioteca.ui.book_detail.components.CategoriesCard
import com.dpam.uanlbiblioteca.ui.core.componets.ScreenLayout
import com.dpam.uanlbiblioteca.ui.core.componets.TopAppBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BookDetailScreen(vm: BookDetailViewModel, onBackClick: () -> Unit) {
    val state by vm.state.collectAsState()

    val sheetState = rememberModalBottomSheetState(
        initialDetent = Hidden,
    )

    ScreenLayout(topBar = {
        TopAppBar(
            title = "",
            onBackClick = onBackClick
        )
    }, floatingActionButton = {
        if (state.bookAvailable.isNotEmpty()) {
            ExtendedFloatingActionButton(
                text = { Text(text = "Solicitar libro") },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_loans),
                        contentDescription = null
                    )
                },
                onClick = {
                    sheetState.currentDetent = FullyExpanded
                }
            )
        }
    }) {
        BookDetailContent(
            campusId = state.campusId,
            bookDetails = state.bookDetails,
            availableLibraries = state.bookAvailable
        )

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
                            text = "Solicitar libro",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Seleccione la biblioteca donde desea solicitar el libro",
                            textAlign = TextAlign.Center
                        )

                        LazyColumn(Modifier.selectableGroup()) {
                            state.bookAvailable.forEach { library ->
                                item {
                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .height(56.dp)
                                            .selectable(
                                                selected = (library.id == state.selectedLibrary),
                                                onClick = { vm.onLoanSelection(selectedLibrary = library.id) },
                                                role = Role.RadioButton
                                            )
                                            .padding(horizontal = 16.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(
                                            selected = (library.id == state.selectedLibrary),
                                            onClick = null
                                        )
                                        Text(
                                            text = library.name,
                                            modifier = Modifier.padding(start = 16.dp)
                                        )
                                    }
                                }
                            }
                        }

                        val selectionTime = listOf("7 dias", "14 dias")

                        Spacer(modifier = Modifier.weight(1f))

                        Text(text = "Seleccione el tiempo de préstamo")

                        Row {
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
                                onClick = { sheetState.currentDetent = Hidden },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(text = "Cancelar")
                            }
                            Spacer(modifier = Modifier.weight(2f))
                            Button(
                                onClick = {
                                    sheetState.currentDetent = Hidden
                                    vm.onLoanBook()
                                    onBackClick()
                                },
                                enabled = state.isLoanEnabled,
                            ) {
                                Text(text = "Solicitar")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BookDetailContent(
    campusId: Long,
    bookDetails: BookWithDetails?,
    availableLibraries: List<LibraryEntity>
) {
    if (bookDetails != null) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                BookCard(bookUrl = bookDetails.book.imageUrl)
            }
            item {
                BookInformation(book = bookDetails.book.asDomain())
            }
            item {
                CategoriesCard(categories = bookDetails.categories.map { it.name })
            }
            item {
                AvailableCard(
                    campusId = campusId,
                    libraries = availableLibraries,
                )
            }
        }
    }
}
