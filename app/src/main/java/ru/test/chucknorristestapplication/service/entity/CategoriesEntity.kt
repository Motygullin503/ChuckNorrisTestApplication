package ru.test.chucknorristestapplication.service.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 27.09.2019
 */
@Entity
class CategoriesEntity(
    @PrimaryKey
    val id: Int,

    val categories: String
)



