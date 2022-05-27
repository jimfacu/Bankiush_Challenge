package com.example.bankiushchallenge.MainScreen

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankiushchallenge.Models.MainScreen.Repository
import com.example.bankiushchallenge.databinding.ItemRepositoryBinding

class AdapterRepository( val detailRepository : DetailRepository) : RecyclerView.Adapter<AdapterRepository.RepositoryViewHolder>() {


    private var repositoryList: MutableList<Repository> = emptyList<Repository>().toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        with(holder.binding){
            tvItemDescription.text = repositoryList[position].full_name


            holder.binding.itemContainer.setOnClickListener {
                detailRepository.goToDetailRepository(repositoryList[position])
            }

        }
    }

    override fun getItemCount(): Int {
       return repositoryList.size
    }

    fun loadList(repoList:List<Repository>){
        repositoryList.addAll(repoList)
        this.notifyDataSetChanged()
    }

    fun clearList(){
        repositoryList.clear()
        this.notifyDataSetChanged()
    }


    inner class RepositoryViewHolder(val binding: ItemRepositoryBinding): RecyclerView.ViewHolder(binding.root)


    interface DetailRepository{
        fun goToDetailRepository(repository: Repository)
    }

}