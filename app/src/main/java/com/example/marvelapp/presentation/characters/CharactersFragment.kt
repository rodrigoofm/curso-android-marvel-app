package com.example.marvelapp.presentation.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.core.domain.model.Character
import com.example.marvelapp.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : Fragment() {

  private val binding by lazy {
    FragmentCharactersBinding.inflate(layoutInflater)
  }

  private val viewModel: CharactersViewModel by viewModels()

  private val charactersAdapter = CharactersAdapter()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View = binding.root

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    lifecycleScope.launch {
      viewModel.charactersPagingData("").collect { pagingData ->
        charactersAdapter.submitData(pagingData)
      }
    }

    initCharactersAdapter()
  }

  private fun initCharactersAdapter() {
    with(binding.recyclerCharacters) {
      setHasFixedSize(true)
      adapter = charactersAdapter
    }
  }
}