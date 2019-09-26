package ru.test.chucknorristestapplication.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.test.chucknorristestapplication.viewmodel.JokeFragmentViewModel

/**
 * @author Bulat Motygullin bul3515@gmail.com
 * 26.09.2019
 */
class JokeViewModelFactory(var category: String) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == JokeFragmentViewModel::class.java) {
            return JokeFragmentViewModel(category) as T
        }
        throw IllegalArgumentException()
    }
}