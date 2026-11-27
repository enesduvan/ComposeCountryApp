package com.enesduvan.composecountryapp.service

import com.enesduvan.composecountryapp.model.CountryModel
import retrofit2.http.GET

interface CountryApi {
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    suspend fun getCountry(): List<CountryModel>
}