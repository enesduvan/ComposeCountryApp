package com.enesduvan.composecountryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.enesduvan.composecountryapp.screens.CountryDetails
import com.enesduvan.composecountryapp.screens.CountryList
import com.enesduvan.composecountryapp.ui.theme.ComposeCountryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCountryAppTheme {
                val navController = rememberNavController()
                NavHost(navController=navController,startDestination= "HomeScreen"){
                    composable ("HomeScreen") {
                        CountryList(navController, viewModel())
                    }
                    composable ("CountryDetails/{CountryName}", arguments = listOf(
                        navArgument("CountryName") { type = NavType.StringType }
                    )) {
                        val CountryName = remember {  it.arguments?.getString("CountryName") ?: "" }
                        CountryDetails(navController, viewModel(), CountryName)
                    }
                }
            }
        }
    }
}