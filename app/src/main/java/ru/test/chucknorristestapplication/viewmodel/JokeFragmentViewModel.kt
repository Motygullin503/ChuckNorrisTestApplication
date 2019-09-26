package ru.test.chucknorristestapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.test.chucknorristestapplication.application.ChuckNorrisApp
import ru.test.chucknorristestapplication.service.model.Joke
import ru.test.chucknorristestapplication.service.repository.CategoryRepository
import ru.test.chucknorristestapplication.service.repository.JokeRepository
import javax.inject.Inject

class JokeFragmentViewModel(category: String): ViewModel() {

    @Inject
    lateinit var jokeRepository: JokeRepository

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _loading

    private val _joke = MutableLiveData<Joke>()
    val joke: LiveData<Joke> = _joke

    init {
        ChuckNorrisApp.getInstance().appComponent.inject(this)
        getJoke(category)
    }

    private fun getJoke(category: String) {
        viewModelScope.launch {
            _joke.postValue(jokeRepository.getJokeByCategory(category))
        }
    }

}