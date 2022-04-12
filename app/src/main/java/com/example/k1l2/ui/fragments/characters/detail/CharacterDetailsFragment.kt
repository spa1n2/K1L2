package com.example.k1l2.ui.fragments.characters.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.k1l2.R
import com.example.k1l2.base.BaseFragment
import com.example.k1l2.base.BaseViewModel
import com.example.k1l2.common.extensions.setImage
import com.example.k1l2.common.resource.Resource
import com.example.k1l2.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailsFragment : BaseFragment<FragmentDetailBinding, BaseViewModel>(
    R.layout.fragment_detail
) {

    override val binding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: CharacterDetailsViewModel by viewModels()
    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun setupViews() {
        getData()
    }

    private fun getData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchCharacterId(args.id).collect {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("loo", "olo")
                    }
                    is Resource.Error -> {
                        Log.e("tag", "Error Character ${it.message.toString()}")
                    }
                    is Resource.Success -> {
                        binding.detailName.text = it.data?.name
                        it.data?.let { it1 -> binding.detailImg.setImage(it1.image) }
                    }
                }
            }
        }
    }
}
