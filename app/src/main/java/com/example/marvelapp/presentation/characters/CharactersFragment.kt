package com.example.marvelapp.presentation.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core.domain.model.Character
import com.example.marvelapp.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

  private val binding by lazy {
    FragmentCharactersBinding.inflate(layoutInflater)
  }

  private val charactersAdapter = CharactersAdapter()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View = binding.root

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initCharactersAdapter()

    charactersAdapter.submitList(
      mockCharactersList()
    )
  }

  private fun initCharactersAdapter() {
    with(binding.recyclerCharacters) {
      setHasFixedSize(true)
      adapter = charactersAdapter
    }
  }

  private fun mockCharactersList(): List<Character> {
    return listOf(
      Character(
        "Spider-Man",
        "https://i.annihil.us/u/prod/marvel/i/mg/e/03/5317713c9e746.jpg"
      ),
      Character(
        "3D-Man",
        "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
      ),
      Character(
        "3D-Man",
        "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
      ),
      Character(
        "3D-Man",
        "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
      )
    )
  }
}