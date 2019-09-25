package ru.test.chucknorristestapplication.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 25.09.2019
 */
class Joke {

    @SerializedName("icon_url")
    @Expose
    private var iconUrl: String? = null
    @SerializedName("id")
    @Expose
    private var id: String? = null
    @SerializedName("url")
    @Expose
    private var url: String? = null
    @SerializedName("value")
    @Expose
    private var value: String? = null

    fun getIconUrl(): String? {
        return iconUrl
    }

    fun setIconUrl(iconUrl: String) {
        this.iconUrl = iconUrl
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getValue(): String? {
        return value
    }

    fun setValue(value: String) {
        this.value = value
    }

}