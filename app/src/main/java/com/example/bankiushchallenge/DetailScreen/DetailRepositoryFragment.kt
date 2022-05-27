package com.example.bankiushchallenge.DetailScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.bankiushchallenge.databinding.FragmentDetailRepositoryBinding


class DetailRepositoryFragment : Fragment() {

    private val args by navArgs<DetailRepositoryFragmentArgs>()

    private var _binding: FragmentDetailRepositoryBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailRepositoryBinding.inflate(inflater,container,false)

        binding.tvTitleAutor.setText(args.repository.owner.login)
        binding.tvTitleRepository.setText(args.repository.name)
        binding.tvNumberWatchers.setText("The number of watchers is: ${args.repository.watchers}")
        binding.tvVisibility.setText("The repository is: ${args.repository.visibility}")
        return binding.root
    }


}