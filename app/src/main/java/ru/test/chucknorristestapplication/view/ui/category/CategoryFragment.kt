package ru.test.chucknorristestapplication.view.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_category.*
import ru.test.chucknorristestapplication.R
import ru.test.chucknorristestapplication.view.adapter.CategoriesAdapter
import ru.test.chucknorristestapplication.view.callback.CategoryCallback
import ru.test.chucknorristestapplication.viewmodel.CategoryFragmentViewModel

class CategoryFragment : Fragment(), CategoryCallback, SwipeRefreshLayout.OnRefreshListener {


    private val mViewModel: CategoryFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(CategoryFragmentViewModel::class.java)
    }
    private val categoriesAdapter = CategoriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureViews()
        observeViewModel()
    }

    private fun configureViews() {
        swipeRefresh.setOnRefreshListener(this)
        categoriesAdapter.categoryCallback = this
        categoryList.adapter = categoriesAdapter
        categoryList.layoutManager = LinearLayoutManager(context)
    }

    private fun observeViewModel() {
        mViewModel.categories.observe(viewLifecycleOwner, Observer { categories ->
            if (categories != null) {
                categoriesAdapter.categories = categories
            }
        })
    }

    override fun onCategoryClicked(category: String) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToJokeFragment(category)
        findNavController().navigate(action)
    }

    override fun onRefresh() {
        mViewModel.update()
        swipeRefresh.isRefreshing = false
    }

}