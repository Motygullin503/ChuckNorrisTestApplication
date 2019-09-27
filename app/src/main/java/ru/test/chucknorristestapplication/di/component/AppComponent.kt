package ru.test.chucknorristestapplication.di.component

import dagger.Component
import ru.test.chucknorristestapplication.di.module.DataModule
import ru.test.chucknorristestapplication.di.module.NetworkModule
import ru.test.chucknorristestapplication.di.module.UtilsModule
import ru.test.chucknorristestapplication.service.repository.CategoryRepositoryImpl
import ru.test.chucknorristestapplication.view.ui.category.CategoryFragment
import ru.test.chucknorristestapplication.viewmodel.CategoryFragmentViewModel
import ru.test.chucknorristestapplication.viewmodel.JokeFragmentViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DataModule::class, UtilsModule::class])
interface AppComponent {

    fun inject(jokeFragmentViewModel: JokeFragmentViewModel)
    fun inject(categoryFragmentViewModel: CategoryFragmentViewModel)
    fun inject(categoryRepositoryImpl: CategoryRepositoryImpl)

}