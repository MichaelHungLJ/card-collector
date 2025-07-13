package com.example.pokemoncardcollector.presentation.cartset

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemoncardcollector.domain.model.CardSet
import com.example.pokemoncardcollector.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SetsViewModel @Inject constructor(
    private val repository : Repository
): ViewModel() {

    private val _cardSets = mutableStateOf<List<CardSet>>(emptyList())
    val cardSets = _cardSets

    init {
//        getAllSets()
    }

    private fun getAllSets() {
        viewModelScope.launch {
            _cardSets.value = repository.getAllSets()
        }
    }
}
