package com.waf.servicentromobile.domain.repository

import com.waf.servicentromobile.domain.model.Vehicle

interface VehicleRepository {
    fun getVehicles(): List<Vehicle>
    fun addVehicle(vehicle: Vehicle)
    fun updateVehicle(vehicle: Vehicle)
    fun deleteVehicle(vehicleId: String)
}