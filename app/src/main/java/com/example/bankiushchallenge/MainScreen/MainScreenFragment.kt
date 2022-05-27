package com.example.bankiushchallenge.MainScreen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankiushchallenge.Data.Success
import com.example.bankiushchallenge.Models.MainScreen.Repository
import com.example.bankiushchallenge.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment(), AdapterRepository.DetailRepository {

    private var _binding:FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModelMainScreen by activityViewModels()

    private var adapter: AdapterRepository? = null

    private var myRepositoryList:MutableList<Repository> = arrayListOf()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if(_binding == null){
            _binding = FragmentMainScreenBinding.inflate(inflater,container,false)
            initOberservers()
            initAdapter()
       }
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.srMainScreen.setOnRefreshListener {
            adapter!!.clearList()
            viewModel.getRepositoriesReset()
        }

        binding.rvGithubRepositories.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                    if ((binding.rvGithubRepositories.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == myRepositoryList.size - 1) {
                        viewModel.getRepositories()
                        binding.pbPagination.visibility = View.VISIBLE
                    }
            }
        })

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun initOberservers() {
        viewModel.repositoryList.observe(this, Observer {

            when(it){
                is Success<*> -> {

                    adapter?.loadList(it.data as List<Repository>)
                    myRepositoryList.addAll(it.data as List<Repository>)


                    if(binding.srMainScreen.isRefreshing){
                        binding.srMainScreen.isRefreshing = false
                        myRepositoryList = arrayListOf()
                        myRepositoryList.addAll(it.data)
                    }

                    checkLoading()
                }
                is Error ->{
                    Toast.makeText(activity, "Failed to download list", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    fun initAdapter(){
        binding.rvGithubRepositories.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRepository(this@MainScreenFragment)
        binding.rvGithubRepositories.adapter = adapter
        viewModel.getRepositories()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkLoading(){
        if(binding.pbMainScreen.isAnimating){
            binding.pbMainScreen.visibility = View.GONE
        }
        if(binding.pbPagination.isAnimating){
            binding.pbPagination.visibility = View.GONE
        }
    }

    override fun goToDetailRepository(repository: Repository) {
        val action = MainScreenFragmentDirections.actionMainScreenFragmentToDetailRepositoryFragment(repository)
        Navigation.findNavController(binding.root).navigate(action)
    }
}