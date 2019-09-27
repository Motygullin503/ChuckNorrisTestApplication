package ru.test.chucknorristestapplication.service.repository

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import ru.test.chucknorristestapplication.application.ChuckNorrisApp
import ru.test.chucknorristestapplication.base.BaseRepository
import ru.test.chucknorristestapplication.service.api.ChuckNorrisApi
import ru.test.chucknorristestapplication.service.dao.CategoryDao
import javax.inject.Inject
import com.squareup.moshi.Types.newParameterizedType
import ru.test.chucknorristestapplication.service.entity.CategoriesEntity


/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 25.09.2019
 */
class CategoryRepositoryImpl(private val chuckNorrisApi: ChuckNorrisApi) : BaseRepository(),
    CategoryRepository {

    @Inject
    lateinit var categoryDao: CategoryDao

    @Inject
    lateinit var moshi: Moshi

    private val categoriesFetchError = "Error Fetching Categories"

    init {
        ChuckNorrisApp.getInstance().appComponent.inject(this)
    }

    override suspend fun getCategories(): List<String>? {

        val list = safeApiCall(
            call = { chuckNorrisApi.getCategories() },
            errorMessage = categoriesFetchError
        )
        if (list != null) {
            postIntoDb(list)
        } else {
            return fetchFromDb()
        }
        return list
    }

    private suspend fun fetchFromDb(): List<String>? {
        return mapStringToList(categoryDao.getCategories().categories)
    }

    private suspend fun postIntoDb(categories: List<String>) {
        categoryDao.insert(CategoriesEntity(1, mapListToString(categories)))
    }

    private fun mapStringToList(categories: String): List<String>? {
        val listType = newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.fromJson(categories)
    }

    private fun mapListToString(categories: List<String>): String {
        val listType = newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.toJson(categories)
    }


}