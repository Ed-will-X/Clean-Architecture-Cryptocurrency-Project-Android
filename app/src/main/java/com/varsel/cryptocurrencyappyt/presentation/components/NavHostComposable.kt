package com.varsel.cryptocurrencyappyt.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.varsel.cryptocurrencyappyt.presentation.Screen
import com.varsel.cryptocurrencyappyt.presentation.coin_detail.CoinDetailScreen
import com.varsel.cryptocurrencyappyt.presentation.coin_list.CoinListScreen

@Composable
fun NavHostComposable() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {
        composable(route = Screen.CoinListScreen.route) {
            CoinListScreen(navController)
        }
        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
            CoinDetailScreen()
        }
    }
}