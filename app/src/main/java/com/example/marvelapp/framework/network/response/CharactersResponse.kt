package com.example.marvelapp.framework.network.response

import com.example.core.domain.model.Character

data class CharactersResponse(
  val id: String,
  val name: String,
  val thumbnail: ThumbnailResponse
)

fun CharactersResponse.toCharacterModel(): Character {
  return Character(
    name = this.name,
    imageUrl = "${this.thumbnail.path}.${this.thumbnail.extensionPath}".replace(
      "http",
      "https"
    )
  )
}
