package ru.test.chucknorristestapplication.service.model

import com.squareup.moshi.Json


/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 25.09.2019
 */
class Joke {

    @Json(name = "icon_url")
    var iconUrl: String? = null

    @Json(name = "id")
    var id: String? = null

    @Json(name = "url")
    var url: String? = null

    @Json(name = "value")
    var value: String? = null



}