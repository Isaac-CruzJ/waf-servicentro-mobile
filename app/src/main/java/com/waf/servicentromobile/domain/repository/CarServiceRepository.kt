package com.waf.servicentromobile.domain.repository

import com.waf.servicentromobile.domain.model.CarService

interface CarServiceRepository {
    fun getAllServices(): List<CarService>
    fun addService(service: CarService)
    fun updateService(id: String, updatedService: CarService)
    fun deleteService(id: String)
}