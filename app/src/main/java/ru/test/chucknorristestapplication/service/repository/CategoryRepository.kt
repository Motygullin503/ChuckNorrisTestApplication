package ru.test.chucknorristestapplication.service.repository

interface CategoryRepository {

    suspend fun getCategories(): List<String>?

}