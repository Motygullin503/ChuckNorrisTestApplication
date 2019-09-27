package ru.test.chucknorristestapplication.service.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.test.chucknorristestapplication.service.model.Joke

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 25.09.2019
 */
interface ChuckNorrisApi {

    @GET("categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("random")
    suspend fun getJokeByCategory(@Query("category") category: String): Response<Joke>

}