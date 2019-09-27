package ru.test.chucknorristestapplication.di.module

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 27.09.2019
 */
@Module
class UtilsModule {

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }
}