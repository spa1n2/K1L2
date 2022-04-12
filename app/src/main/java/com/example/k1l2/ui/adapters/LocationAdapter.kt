package com.example.k1l2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.k1l2.base.BaseDiffUtil
import com.example.k1l2.databinding.ItemLocationsBinding
import com.example.k1l2.models.RickAndMortyLocations

class LocationAdapter :
    ListAdapter<RickAndMortyLocations, LocationAdapter.LocationViewHolder>(
        BaseDiffUtil()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): LocationViewHolder =
        LocationViewHolder(
            ItemLocationsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class LocationViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: RickAndMortyLocations) {
            binding.itemName.text = model.name
            binding.itemType.text = model.type
        }
    }
}
