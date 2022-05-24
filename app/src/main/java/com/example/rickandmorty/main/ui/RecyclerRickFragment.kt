package com.example.rickandmorty.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentRecyclerRickAndMortyBinding
import com.example.rickandmorty.common.BaseFragmentMvp
import com.example.rickandmorty.main.api.model.CharacterApiResponse
import com.example.rickandmorty.main.api.model.ResultsResponse
import com.example.rickandmorty.main.model.Results
import org.koin.android.ext.android.inject
import timber.log.Timber


class RecyclerRickFragment : BaseFragmentMvp<RickMortyView.View, RickMortyView.Presenter>(R.layout.fragment_recycler_rick_and_morty), RickMortyView.View{

    private lateinit var binding: FragmentRecyclerRickAndMortyBinding

    override val presenter: RickMortyView.Presenter by inject()

    private val mainAdapter: MainAdapter by lazy {
        MainAdapter ( onClick = { showDetailsItem(it) } )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerRickAndMortyBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        mainRecyclerView.layoutManager = LinearLayoutManager(context)
        mainRecyclerView.adapter = mainAdapter
        presenter.getCharacterList()
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    private fun showDetailsItem(results: Results) {
        val fragment =  CharacterInfoFragment()
        val bundle = Bundle()
        bundle.putParcelable("result", results)
        fragment.arguments = bundle
        replaceFragment(fragment)
    }



    override fun showHeroList(results: List<Results>) {
        mainAdapter.setData(results)
    }

    override fun onFail(throwable: Throwable) {
        Timber.e(throwable.message)
    }


}
