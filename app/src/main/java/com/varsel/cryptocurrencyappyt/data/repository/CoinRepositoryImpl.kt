package com.varsel.cryptocurrencyappyt.data.repository

import com.varsel.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.varsel.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.varsel.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.varsel.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCounById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}