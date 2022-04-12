package com.example.k1l2.data.repositories

import com.example.k1l2.base.BaseRepository
import com.example.k1l2.data.local.db.daos.CharacterDao
import com.example.k1l2.data.remote.apiservices.CharacterApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService,
    private val characterDao: CharacterDao
) :
    BaseRepository() {

    fun fetchCharacters(page: Int) = doRequest(
        { service.fetchCharacters(page) },
        { characters -> characterDao.insertAll(* characters.result.toTypedArray()) })

    fun fetchCharacterID(id: Int) = doRequest {
        service.fetchCharacterId(id)
    }

    fun getCharacters() = doRequest {
        characterDao.getAll()
    }

}

