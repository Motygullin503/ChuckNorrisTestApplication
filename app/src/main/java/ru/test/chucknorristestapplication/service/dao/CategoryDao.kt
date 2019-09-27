package ru.test.chucknorristestapplication.service.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.test.chucknorristestapplication.service.entity.CategoriesEntity

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 27.09.2019
 */
@Dao
interface CategoryDao {

    @Query("SELECT * FROM CategoriesEntity WHERE id = 1")
    suspend fun getCategories(): CategoriesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(categoriesEntity: CategoriesEntity)

}