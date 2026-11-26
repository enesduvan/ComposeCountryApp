package com.enesduvan.composecountryapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountryListViewModel : ViewModel() {
    val country = MutableLiveData<List<CountryModel>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refeshData() {
        countryLoading.value = true
        countryError.value = false

        val countryList = listOf(
            CountryModel("Turkey", "Ankara", "Europe/Asia", "Turkish", "https://upload.wikimedia.org/wikipedia/commons/b/b4/Flag_of_Turkey.svg"),
            CountryModel("Germany", "Berlin", "Europe", "German", "https://upload.wikimedia.org/wikipedia/en/b/ba/Flag_of_Germany.svg"),
            CountryModel("France", "Paris", "Europe", "French", "https://upload.wikimedia.org/wikipedia/en/c/c3/Flag_of_France.svg")
        )

        country.value = countryList
        countryLoading.value = false
    }
}