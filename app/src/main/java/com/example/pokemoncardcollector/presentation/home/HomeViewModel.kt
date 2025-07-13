package com.example.pokemoncardcollector.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemoncardcollector.domain.model.Card
import com.example.pokemoncardcollector.domain.model.CardSet
import com.example.pokemoncardcollector.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cardRepository: Repository
): ViewModel() {

    private val _card = mutableStateOf<Card?>(null)
    val card: State<Card?> = _card

    private val _cardSets = mutableStateOf<List<CardSet>>(emptyList())
    val cardSets: State<List<CardSet>> = _cardSets

    init {
        getCardById("xy1-1")
    }

    fun getCardById(id: String) {
        viewModelScope.launch {
            _card.value = cardRepository.getCardById(id)
        }
    }

    fun getAllSets() {
        viewModelScope.launch {
            _cardSets.value = cardRepository.getAllSets()
        }
    }
}
