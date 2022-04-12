package com.example.k1l2.data.repositories

import com.example.k1l2.base.BaseRepository
import com.example.k1l2.data.local.db.daos.LocationDao
import com.example.k1l2.data.remote.apiservices.LocationsApiService
import javax.inject.Inject

class LocationsRepositories @Inject constructor(
    private val service: LocationsApiService,
    private val locationDao: LocationDao
) :
    BaseRepository() {

    fun fetchLocations(page: Int) = doRequest(
        { service.fetchLocations(page) },
        { location -> locationDao.insertAll(* location.result.toTypedArray()) })


    fun getLocation() = doRequest {
        locationDao.getAll()
    }
}