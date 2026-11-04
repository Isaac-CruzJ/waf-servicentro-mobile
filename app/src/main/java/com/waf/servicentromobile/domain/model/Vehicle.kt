package com.waf.servicentromobile.domain.model

data class Vehicle(
    val id: String,
    val licensePlate: String,
    val brand: String,
    val model: String,
    val imageUrl: String? = null
)