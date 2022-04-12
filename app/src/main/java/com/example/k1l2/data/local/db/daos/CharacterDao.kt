package com.example.k1l2.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.k1l2.models.RickAndMortyCharacters

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg characters: RickAndMortyCharacters)

    @Query("SELECT *FROM rickandmortycharacters")
    suspend fun getAll(): List<RickAndMortyCharacters>
}