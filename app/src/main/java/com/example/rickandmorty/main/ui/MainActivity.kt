package com.example.rickandmorty.main.ui

import android.os.Bundle
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.common.BaseActivity

class MainActivity() : BaseActivity(){

    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val recyclerRickFragment = RecyclerRickFragment()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        changeFragment(recyclerRickFragment, R.id.container)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        clearBackStack()
    }


}