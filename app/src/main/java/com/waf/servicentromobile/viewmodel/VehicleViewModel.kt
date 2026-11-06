package com.waf.servicentromobile.viewmodel

import androidx.lifecycle.ViewModel
import com.waf.servicentromobile.data.memory.MemoryDataRepository
import com.waf.servicentromobile.domain.model.Vehicle

class VehicleViewModel : ViewModel() {

    fun getVehicles(): List<Vehicle> {
        return MemoryDataRepository.getVehicles()
    }

    fun addVehicle(vehicle: Vehicle) {
        MemoryDataRepository.addVehicle(vehicle)
    }

    fun deleteVehicle(vehicleId: String) {
        MemoryDataRepository.deleteVehicle(vehicleId)
    }
}