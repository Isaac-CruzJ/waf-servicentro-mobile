package com.waf.servicentromobile.domain.model

data class CarService(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val durationMinutes: Int
)