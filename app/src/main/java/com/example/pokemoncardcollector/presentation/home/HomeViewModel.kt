package com.example.pokemoncardcollector.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemoncardcollector.domain.model.Card
import com.example.pokemoncardcollector.domain.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cardRepository: CardRepository
): ViewModel() {

    private val _card = mutableStateOf<Card?>(null)
    val card: State<Card?> = _card


    init {
        getCardById("xy1-1")
    }

    fun getCardById(id: String) {
        viewModelScope.launch {
            _card.value = cardRepository.getCardById(id)
        }
    }
}
