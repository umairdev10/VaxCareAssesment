package com.vaco.vaxcareassesment.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BookDetailView(viewModel: BookDetailViewModel = hiltViewModel(), paddingValues: PaddingValues) {
    val state = viewModel.state.value
    state.book?.let {
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            Text(text = it.title, style = MaterialTheme.typography.headlineMedium)
            Text(text = "Author: ${it.author}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Shelf: ${it.displayText}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Time Checked In: ${it.timeCheckedIn}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Fee: $${it.fee}", style = MaterialTheme.typography.bodySmall)
        }
    }
}