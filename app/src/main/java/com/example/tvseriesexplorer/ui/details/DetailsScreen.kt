package com.example.tvseriesexplorer.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.tvseriesexplorer.model.TvShowDetails
import com.example.tvseriesexplorer.ui.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    showId: String,
    onBack: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(showId) {
        if (showId.isNotBlank()) {
            viewModel.loadDetails(showId)
        }
    }

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Détails de la série") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Retour"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        when (uiState) {
            is UiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Error -> {
                val message = (uiState as UiState.Error).message ?: "Erreur inconnue"
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Erreur : $message",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            is UiState.Success -> {
                val details = (uiState as UiState.Success<TvShowDetails>).data
                DetailsContent(
                    details = details,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
private fun DetailsContent(
    details: TvShowDetails,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = details.imageUrl,
            contentDescription = details.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = details.name,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(8.dp))

        Text(text = "Note : ${details.rating ?: "N/A"}")
        Text(text = "Nombre d'épisodes : ${details.episodesCount}")

        Spacer(Modifier.height(16.dp))

        Text(
            text = details.description ?: "Aucun résumé disponible.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
