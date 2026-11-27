package com.enesduvan.composecountryapp.service

import com.enesduvan.composecountryapp.model.CountryModel
import retrofit2.Retrofit

class CountryApiService  {
    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
        .build()
        .create(CountryApi::class.java)
    suspend fun getData() : List<CountryModel> {
        return api.getCountry()
    }
}