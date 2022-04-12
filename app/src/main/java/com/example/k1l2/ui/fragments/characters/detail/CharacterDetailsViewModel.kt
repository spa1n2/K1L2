package com.example.k1l2.ui.fragments.characters.detail

import com.example.k1l2.base.BaseViewModel
import com.example.k1l2.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {
    fun fetchCharacterId(id: Int) = repository.fetchCharacterID(id)
}