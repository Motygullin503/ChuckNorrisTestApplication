package ru.test.chucknorristestapplication.di.module

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
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
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
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