package com.enesduvan.composecountryapp.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enesduvan.composecountryapp.service.CountryApiService
import kotlinx.coroutines.launch

class CountryDetailsViewModel : ViewModel() {
    val selectedCountry = MutableLiveData<CountryModel?>()
    val isLoading = MutableLiveData<Boolean>()
    private val countryApiService = CountryApiService()

    fun loadCountry(name: String) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val decodedName = android.net.Uri.decode(name)
                val countryList = countryApiService.getData()
                val foundCountry = countryList.firstOrNull {
                    it.name.equals(decodedName.trim(), ignoreCase = true)
                }
                selectedCountry.value = foundCountry

                if (foundCountry == null) {
                    Log.e("CountryDetails", "Ülke bulunamadı. Aranan: '$decodedName'")
                }
            } catch (e: Exception) {
                Log.e("CountryDetails", "API Hatası: ${e.message}")
            } finally {
                isLoading.value = false
            }
        }
    }
}