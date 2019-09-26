package ru.test.chucknorristestapplication.view.ui.joke

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_joke.*
import ru.test.chucknorristestapplication.R
import ru.test.chucknorristestapplication.service.model.Joke
import ru.test.chucknorristestapplication.utils.JokeViewModelFactory
import ru.test.chucknorristestapplication.viewmodel.JokeFragmentViewModel
import java.text.SimpleDateFormat
import java.util.*


class JokeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private val args: JokeFragmentArgs by navArgs()
    lateinit var category: String
    private var mViewModel: JokeFragmentViewModel? = null
    
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category = args.category
        val factory = JokeViewModelFactory(category)
        mViewModel = ViewModelProviders.of(this, factory).get(JokeFragmentViewModel::class.java)
        swipeRefresh.setOnRefreshListener(this)
        observeViewModel()
    }

    private fun observeViewModel() {

        mViewModel?.joke?.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                configureViews(it)
            }
        })

        mViewModel?.isLoading?.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                loading.visibility = if (it) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        })
    }

    private fun configureViews(joke: Joke) {

        text.text = joke.value
        Glide.with(context!!)
                .load(joke.icon_url)
                .into(image)

        date.text = formatDate(joke.created_at)
    }

    private fun formatDate(date: String?): String {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSS", Locale.getDefault())
        val fullDate = format.parse(date)
        return "${DateFormat.format("dd", fullDate)} ${DateFormat.format("MMM", fullDate)}"
    }

    override fun onRefresh() {
        mViewModel?.getJoke(category)
        swipeRefresh.isRefreshing = false
    }
}