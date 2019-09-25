package ru.test.chucknorristestapplication.service.model

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 25.09.2019
 */
sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}