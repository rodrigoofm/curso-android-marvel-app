package com.example.marvelapp.framework.remote

import com.example.core.data.repository.CharactersRemoteDataSource
import com.example.marvelapp.framework.network.MarvelService
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
  private val service: MarvelService
) : CharactersRemoteDataSource<DataWrapperResponse> {

  override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
    return service.getCharacters(queries)
  }
}