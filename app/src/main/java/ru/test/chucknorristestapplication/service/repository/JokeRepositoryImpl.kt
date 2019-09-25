package ru.test.chucknorristestapplication.service.repository

import ru.test.chucknorristestapplication.base.BaseRepository
import ru.test.chucknorristestapplication.service.api.ChuckNorrisApi
import ru.test.chucknorristestapplication.service.model.Joke

class JokeRepositoryImpl(private val chuckNorrisApi: ChuckNorrisApi) : BaseRepository(),
    JokeRepository {

    private val fetchError = "Error Fetching Joke"

    override suspend fun getJokeByCategory(category: String): Joke? {

        return safeApiCall(
            call = { chuckNorrisApi.getJokeByCategory(category) },
            errorMessage = fetchError
        )
    }
}