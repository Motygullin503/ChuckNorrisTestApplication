package ru.test.chucknorristestapplication.di.component

import dagger.Component
import ru.test.chucknorristestapplication.di.module.NetworkModule
import ru.test.chucknorristestapplication.view.ui.category.CategoryFragment
import ru.test.chucknorristestapplication.viewmodel.CategoryFragmentViewModel
import ru.test.chucknorristestapplication.viewmodel.JokeFragmentViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(jokeFragmentViewModel: JokeFragmentViewModel)
    fun inject(categoryFragmentViewModel: CategoryFragmentViewModel)

}