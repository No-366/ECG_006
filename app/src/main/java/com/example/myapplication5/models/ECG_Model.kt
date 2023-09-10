package com.example.myapplication5.models

import java.time.Instant




data class ECG_Model(
    private val dateTime: Instant,
    private val jwt: String,
    private val ecgData: List<Long?>,
    private val bpm: Long
)
{

    fun getDateTime(): Instant{
        return dateTime
    }

    fun getJwt(): String{
        return jwt
    }

    fun getEcgData(): List<Long?>{
        return ecgData
    }

    fun getBpm(): Long{
        return bpm
    }

}