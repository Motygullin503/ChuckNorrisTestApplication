package ru.test.chucknorristestapplication.base

import android.util.Log
import retrofit2.Response
import ru.test.chucknorristestapplication.service.model.Result
import java.io.IOException

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 25.09.2019
 */
open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {

        val result : Result<T> = safeApiResult(call,errorMessage)
        var data : T? = null

        when(result) {
            is Result.Success ->
                data = result.data
            is Result.Error -> {
                Log.d("BaseRepository", "$errorMessage & Exception - ${result.exception}")
            }
        }

        return data

    }

    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>, errorMessage: String) : Result<T>{
        try {
            val response = call.invoke()
            if (response.isSuccessful) return Result.Success(response.body()!!)
        } catch (e: Exception) {
            return Result.Error(IOException("Error Occurred during getting safe Api result, ERROR - $errorMessage"))
        }
        return Result.Error(IOException("Error Occurred during getting safe Api result, ERROR - $errorMessage"))
    }

}