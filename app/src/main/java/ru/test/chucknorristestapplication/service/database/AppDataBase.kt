package ru.test.chucknorristestapplication.service.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.test.chucknorristestapplication.service.dao.CategoryDao
import ru.test.chucknorristestapplication.service.entity.CategoriesEntity

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 27.09.2019
 */
@Database(entities = [CategoriesEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
}