package com.example.k1l2.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.k1l2.models.RickAndMortyLocations


@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg locations: RickAndMortyLocations)

    @Query("SELECT *FROM rickandmortylocations ")
    suspend fun getAll(): List<RickAndMortyLocations>
}