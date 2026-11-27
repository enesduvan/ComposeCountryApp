package com.enesduvan.composecountryapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enesduvan.composecountryapp.service.CountryApiService
import kotlinx.coroutines.launch

class CountryListViewModel : ViewModel() {
    val country = MutableLiveData<List<CountryModel>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()
    private val countryApiService = CountryApiService()

    fun refeshData(){
        viewModelScope.launch {
            countryLoading.value = true
            countryError.value = false
            try {
                val countryList = countryApiService.getData()
                country.value = countryList
                countryError.value = false
            } catch (e: Exception) {
                countryError.value = true
                e.printStackTrace()
            } finally {
                countryLoading.value = false
            }
        }
    }
}