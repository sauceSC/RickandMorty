package com.example.rickandmorty.main.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.common.BaseFragment
import com.example.rickandmorty.databinding.FragmentRecyclerRickAndMortyBinding
import com.example.rickandmorty.main.model.Results
import com.example.rickandmorty.main.ui.MainViewModel
import com.example.rickandmorty.main.ui.adapters.MainAdapter
import com.example.rickandmorty.main.ui.replaceFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class RecyclerRickFragment : BaseFragment(R.layout.fragment_recycler_rick_and_morty) {

    private lateinit var binding: FragmentRecyclerRickAndMortyBinding

    private val viewModel: MainViewModel by viewModel()

    private val adapter: MainAdapter by lazy {
        MainAdapter(onClick = { showDetailsItem(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerRickAndMortyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createRecycler()
        viewModel.listLiveData.observe(viewLifecycleOwner) { data ->
            adapter.setItems(data as ArrayList<Results>)
        }
        viewModel.loadRickMorty()
    }

    private fun showDetailsItem(results: Results) {
        val fragment = CharacterInfoFragment()
        val bundle = Bundle()
        bundle.putParcelable("result", results)
        fragment.arguments = bundle
        replaceFragment(fragment)
    }


    private fun createRecycler() = with(binding){
        mainRecyclerView.adapter = adapter
        mainRecyclerView.layoutManager = LinearLayoutManager(context)
    }

}
