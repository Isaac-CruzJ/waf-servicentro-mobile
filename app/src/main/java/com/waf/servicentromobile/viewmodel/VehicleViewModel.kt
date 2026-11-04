package com.waf.servicentromobile.viewmodel

import androidx.lifecycle.ViewModel
import com.waf.servicentromobile.data.memory.MemoryDataRepository
import com.waf.servicentromobile.domain.model.Vehicle

class VehicleViewModel : ViewModel() {
    private val repository = MemoryDataRepository()

    fun getVehicles(): List<Vehicle> = repository.getVehicles()

    fun addNewVehicle(id: String, plate: String, brand: String, model: String) {
        repository.addVehicle(Vehicle(id, plate, brand, model))
    }

    fun removeVehicle(id: String) {
        repository.deleteVehicle(id)
    }
}