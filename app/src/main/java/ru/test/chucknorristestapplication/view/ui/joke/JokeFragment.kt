package ru.test.chucknorristestapplication.view.ui.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ru.test.chucknorristestapplication.R
import ru.test.chucknorristestapplication.viewmodel.JokeFragmentViewModel

class JokeFragment : Fragment() {

    private val mViewModel: JokeFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(JokeFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureViews()
        observeViewModel()
    }

    private fun configureViews() {


    }

    private fun observeViewModel() {


    }

}