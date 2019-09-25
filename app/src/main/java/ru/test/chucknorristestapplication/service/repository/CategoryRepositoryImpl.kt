package ru.test.chucknorristestapplication.service.repository

import ru.test.chucknorristestapplication.base.BaseRepository
import ru.test.chucknorristestapplication.service.api.ChuckNorrisApi

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 25.09.2019
 */
class CategoryRepositoryImpl(private val chuckNorrisApi: ChuckNorrisApi) : BaseRepository(),
    CategoryRepository {

    private val categoriesFetchError = "Error Fetching Categories"

    override suspend fun getCategories(): List<String>? {

        return safeApiCall(
            call = { chuckNorrisApi.getCategories() },
            errorMessage = categoriesFetchError
        )
    }
}