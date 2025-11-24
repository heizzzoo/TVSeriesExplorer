package com.example.tvseriesexplorer.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvseriesexplorer.data.TvShowsRepository
import com.example.tvseriesexplorer.model.TvShowDetails
import com.example.tvseriesexplorer.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: TvShowsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<TvShowDetails>>(UiState.Loading)
    val uiState: StateFlow<UiState<TvShowDetails>> = _uiState

    fun loadDetails(idOrPermalink: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val details = repository.getShowDetails(idOrPermalink)
                _uiState.value = UiState.Success(details)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message)
            }
        }
    }
}
