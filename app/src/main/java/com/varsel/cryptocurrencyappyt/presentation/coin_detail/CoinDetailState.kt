package com.varsel.cryptocurrencyappyt.presentation.coin_detail

import com.varsel.cryptocurrencyappyt.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
