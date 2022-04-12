package com.example.k1l2.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.k1l2.data.local.db.daos.CharacterDao
import com.example.k1l2.data.local.db.daos.EpisodesDao
import com.example.k1l2.data.local.db.daos.LocationDao
import com.example.k1l2.models.RickAndMortyCharacters
import com.example.k1l2.models.RickAndMortyEpisodes
import com.example.k1l2.models.RickAndMortyLocations

@Database(entities = [RickAndMortyCharacters::class, RickAndMortyLocations::class, RickAndMortyEpisodes::class],
    version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
    abstract fun episodesDao(): EpisodesDao
}