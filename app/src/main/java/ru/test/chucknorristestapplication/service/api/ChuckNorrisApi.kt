package ru.test.chucknorristestapplication.service.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.test.chucknorristestapplication.service.model.Joke

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 25.09.2019
 */
interface ChuckNorrisApi {

    @GET("/categories")
    fun getCategories() : Deferred<Response<List<String>>>

    @GET("/random?category={category}")
    fun getJokeByCategory(@Path("category") category:String): Deferred<Response<Joke>>

}