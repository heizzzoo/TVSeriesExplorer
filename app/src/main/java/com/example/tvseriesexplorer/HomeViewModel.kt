package com.example.tvseriesexplorer.ui.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.tvseriesexplorer.model.TvShow
import com.example.tvseriesexplorer.ui.UiState

@Composable
fun HomeScreen(
    onShowClick: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val query by viewModel.query.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = viewModel::onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Rechercher une série") }
        )

        Spacer(Modifier.height(8.dp))

        Row {
            Button(onClick = { viewModel.search() }) {
                Text("Rechercher")
            }
            Spacer(Modifier.width(8.dp))
            TextButton(onClick = { viewModel.loadPopular() }) {
                Text("Populaires")
            }
        }

        Spacer(Modifier.height(16.dp))

        // 🔥 Animation de transition entre Loading / Error / Success
        Crossfade(targetState = uiState, label = "homeState") { state ->
            when (state) {
                is UiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is UiState.Error -> {
                    val message = state.message ?: "Erreur inconnue"
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Erreur : $message",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }

                is UiState.Success -> {
                    val shows = state.data
                    if (shows.isEmpty()) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Aucune série trouvée.")
                        }
                    } else {
                        LazyColumn {
                            items(
                                items = shows,
                                key = { it.id }   // important pour l’animation
                            ) { show ->
                                TvShowItem(
                                    show = show,
                                    onClick = { onShowClick(show.id) }
                                )
                                HorizontalDivider()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TvShowItem(
    show: TvShow,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            // 🔥 Animation de déplacement quand la liste change
            .animateItemPlacement()
            .clickable { onClick() }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = show.imageUrl,
            contentDescription = show.name,
            modifier = Modifier.size(80.dp)
        )

        Spacer(Modifier.width(12.dp))

        Column {
            Text(text = show.name, style = MaterialTheme.typography.titleMedium)
            if (!show.network.isNullOrBlank()) {
                Text(
                    text = show.network!!,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
