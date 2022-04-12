package com.example.k1l2.data.repositories

import com.example.k1l2.base.BaseRepository
import com.example.k1l2.data.local.db.daos.EpisodesDao
import com.example.k1l2.data.remote.apiservices.EpisodesApiService
import javax.inject.Inject

class EpisodesRepositories @Inject constructor(
    private val service: EpisodesApiService,
    private val episodesDao: EpisodesDao
) :
    BaseRepository() {

    fun fetchEpisodes(page: Int) = doRequest(
        { service.fetchEpisodes(page) },
        { episodes -> episodesDao.insertAll(* episodes.result.toTypedArray()) })


    fun getEpisodes() = doRequest {
        episodesDao.getAll()
    }
}