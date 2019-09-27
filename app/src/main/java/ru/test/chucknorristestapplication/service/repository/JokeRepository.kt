package ru.test.chucknorristestapplication.service.repository

import ru.test.chucknorristestapplication.service.model.Joke

interface JokeRepository {

    suspend fun getJokeByCategory(category: String): Joke?

}