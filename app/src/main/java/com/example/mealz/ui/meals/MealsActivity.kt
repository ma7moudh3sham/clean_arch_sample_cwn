package com.example.mealz.ui.meals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mealz.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsActivity : AppCompatActivity() {

    private val viewModel: MealsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRV()
        subscribeViewModel()
        viewModel.getMealsCategories()
    }

    private fun subscribeViewModel() {
        lifecycleScope.launch {
            viewModel.category.collect{
                adapter.submitList(it?.categories)
            }
        }
    }

    private fun setupRV() {
        adapter = MealsAdapter()
        binding.categoryRv.adapter = adapter
    }
}