package ru.test.chucknorristestapplication.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.test.chucknorristestapplication.service.dao.CategoryDao
import ru.test.chucknorristestapplication.service.database.AppDataBase
import javax.inject.Singleton

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 27.09.2019
 */
@Module
class DataModule(context: Context) {

    val DATABASE_NAME = "database"

    private var dataBase: AppDataBase

    init {
        dataBase = Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesDataBase(): AppDataBase {
        return dataBase
    }

    @Provides
    fun providesSaveGameDao(): CategoryDao {
        return dataBase.categoryDao()
    }
}