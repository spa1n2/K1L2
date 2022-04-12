package com.example.k1l2.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.k1l2.base.BaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity
class RickAndMortyLocations(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String,
) : BaseDiffModel
