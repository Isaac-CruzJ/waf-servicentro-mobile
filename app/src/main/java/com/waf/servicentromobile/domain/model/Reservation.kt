package com.waf.servicentromobile.domain.model

data class Reservation(
    val id: String,
    val vehicleId: String,
    val serviceId: String,
    val date: String,
    val status: String
)