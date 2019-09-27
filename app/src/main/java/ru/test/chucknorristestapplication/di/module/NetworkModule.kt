package ru.test.chucknorristestapplication.di.module

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.test.chucknorristestapplication.service.api.ChuckNorrisApi
import ru.test.chucknorristestapplication.service.repository.CategoryRepository
import ru.test.chucknorristestapplication.service.repository.CategoryRepositoryImpl
import ru.test.chucknorristestapplication.service.repository.JokeRepository
import ru.test.chucknorristestapplication.service.repository.JokeRepositoryImpl
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule(private val baseUrl: String) {

    val logInterceptor: Interceptor
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            return logging
        }

    @Provides
    @Singleton
    fun providesRetrofit(
    ): Retrofit {

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(provideOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit
    }

    @Provides
    fun provideChuckNorrisApi(
    ): ChuckNorrisApi {
        return providesRetrofit().create(ChuckNorrisApi::class.java)
    }

    @Provides
    fun provideCategoryRepository(
    ): CategoryRepository {
        return CategoryRepositoryImpl(provideChuckNorrisApi())
    }

    @Provides
    fun provideJokeRepository(
    ): JokeRepository {
        return JokeRepositoryImpl(provideChuckNorrisApi())
    }


    private fun provideOkHttpClient(): OkHttpClient {
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.apply {

            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
            addInterceptor(logInterceptor)
        }
        return okhttpClientBuilder.build()
    }
}