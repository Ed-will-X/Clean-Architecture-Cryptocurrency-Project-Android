package com.varsel.cryptocurrencyappyt.domain.repository

import com.varsel.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.varsel.cryptocurrencyappyt.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCounById(coinId: String): CoinDetailDto
}