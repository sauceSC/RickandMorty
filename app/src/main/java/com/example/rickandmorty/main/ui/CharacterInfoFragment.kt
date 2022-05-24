package com.example.rickandmorty.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterInfoBinding
import com.example.rickandmorty.main.api.model.ResultsResponse
import com.example.rickandmorty.main.model.Results

class CharacterInfoFragment : Fragment(R.layout.fragment_character_info){
   private val binding: FragmentCharacterInfoBinding by lazy {
       FragmentCharacterInfoBinding.inflate(layoutInflater)
   }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = with(binding){
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getParcelable<Results>("result") as Results
        with(binding){
            context?.let { Glide.with(it).load(data.image).into(image) }
            name.text = data.name
            gender.text = data.gender

        }
    }
}