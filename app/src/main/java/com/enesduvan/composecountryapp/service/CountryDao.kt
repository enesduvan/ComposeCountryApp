package com.enesduvan.composecountryapp.service

import androidx.room3.Insert
import androidx.room3.Query
import com.enesduvan.composecountryapp.model.CountryModel

interface CountryDao {
    @Insert suspend fun insertAll(vararg countryModel: CountryModel)
    @Query("SELECT * FROM CountryModel") suspend fun getAllCountries(): List<CountryModel>
    @Query("SELECT * FROM CountryModel WHERE id = :countryId") suspend fun getCountryById(countryId: Int): CountryModel
}