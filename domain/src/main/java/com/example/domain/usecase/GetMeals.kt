package com.example.domain.usecase

import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.MealsRepo

//usecases will be used in viewModel only
class GetMeals (private val mealsRepo: MealsRepo){
    suspend operator fun invoke() = mealsRepo.getMealsFromRemote()

//    suspend fun getMeals(): CategoryResponse{
//        return mealsRepo.getMealsFromRemote()
//    }
}

/**
 * we use operator fun as this class only have one fun so to make it ease to call it with only the class name like: GetMeals()
 * instead of making object of the class then call it's function.
 * note: u can pass args in invoke(here) just in case u need to..
 */
