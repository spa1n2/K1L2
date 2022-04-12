package com.example.k1l2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.k1l2.base.BaseDiffUtil
import com.example.k1l2.common.extensions.setImage
import com.example.k1l2.databinding.ItemCharactersBinding
import com.example.k1l2.models.RickAndMortyCharacters

class CharacterAdapter(val onItemClickListener: (id: Int) -> Unit) :
    ListAdapter<RickAndMortyCharacters, CharacterAdapter.CharacterViewHolder>(
        BaseDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class CharacterViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: RickAndMortyCharacters) {
            binding.itemImg.setImage(data.image)
            binding.itemName.text = data.name
        }

        init {
            binding.root.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { m -> onItemClickListener(m.id) }
            }
        }
    }
}
