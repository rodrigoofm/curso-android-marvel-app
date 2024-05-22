package com.example.marvelapp.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.domain.model.Character
import com.example.marvelapp.R
import com.example.marvelapp.databinding.ItemCharacterBinding

class CharactersViewHolder(
  itemBinding: ItemCharacterBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

  private val textName = itemBinding.textName
  private val imageCharacter = itemBinding.imageCharacter

  fun bind(character: Character) {
    textName.text = character.name
    Glide.with(itemView)
      .load(character.imageUrl)
      .fallback(R.drawable.ic_img_loading_error) // Imagem default
      .into(imageCharacter) // Onde a imagem vai ser carregada
  }

  companion object {

    /**
     * Função criada para facilitar a usabilidade em outras classes.
     * Assim as classes só chamam a função create e não precisam repetir o código de inflater
     */

    fun create(parent: ViewGroup): CharactersViewHolder {
      val inflater = LayoutInflater.from(parent.context)
      val itemBinding = ItemCharacterBinding.inflate(inflater, parent, false)
      return CharactersViewHolder(itemBinding)
    }
  }
}