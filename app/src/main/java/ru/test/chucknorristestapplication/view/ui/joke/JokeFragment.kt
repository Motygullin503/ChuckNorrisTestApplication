package ru.test.chucknorristestapplication.view.ui.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_joke.*
import ru.test.chucknorristestapplication.R
import ru.test.chucknorristestapplication.service.model.Joke
import ru.test.chucknorristestapplication.utils.JokeViewModelFactory
import ru.test.chucknorristestapplication.viewmodel.JokeFragmentViewModel

class JokeFragment : Fragment() {

    private val mViewModel: JokeFragmentViewModel by lazy {
        val factory = JokeViewModelFactory(category)
        ViewModelProviders.of(this, factory).get(JokeFragmentViewModel::class.java)
    }

    private lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        observeViewModel()
    }

    private fun observeViewModel() {

        mViewModel.joke.observe(viewLifecycleOwner, Observer {
            configureViews(it)
        })
    }
    private fun configureViews(joke: Joke) {

        text.text = joke.value

    }
}