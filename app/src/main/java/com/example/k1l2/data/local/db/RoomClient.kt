package com.example.k1l2.data.local.db

import android.content.Context
import androidx.room.Room
import com.example.k1l2.data.local.db.daos.CharacterDao
import com.example.k1l2.data.local.db.daos.EpisodesDao
import com.example.k1l2.data.local.db.daos.LocationDao

class RoomClient {

    fun provideCreateAppDatabase(context: Context) = Room.databaseBuilder(
        context, AppDatabase::class.java, "database-name"
    ).fallbackToDestructiveMigration()
        .build()

    fun provideCharacterDao(characterAppDatabase: AppDatabase): CharacterDao =
        characterAppDatabase.characterDao()

    fun provideLocationDao(locationAppDatabase: AppDatabase): LocationDao =
        locationAppDatabase.locationDao()

    fun provideEpisodesDao(episodesAppDatabase: AppDatabase): EpisodesDao =
        episodesAppDatabase.episodesDao()
}