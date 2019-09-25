package ru.test.chucknorristestapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.test.chucknorristestapplication.service.repository.CategoryRepository
import javax.inject.Inject

class CategoryFragmentViewModel: ViewModel() {

    @Inject
    lateinit var categoryRepository: CategoryRepository

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _loading

    private val _categories = MutableLiveData<List<String>>()
    val categories: LiveData<List<String>> = _categories

    init {
        update()
    }

    private fun update() {
        viewModelScope.launch {
            _categories.postValue(categoryRepository.getCategories())
        }
    }

}