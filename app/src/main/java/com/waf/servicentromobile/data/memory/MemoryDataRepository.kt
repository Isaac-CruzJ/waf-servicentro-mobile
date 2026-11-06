package com.waf.servicentromobile.data.memory

import com.waf.servicentromobile.domain.model.CarService
import com.waf.servicentromobile.domain.model.Reservation
import com.waf.servicentromobile.domain.model.Vehicle
import com.waf.servicentromobile.domain.repository.CarServiceRepository
import com.waf.servicentromobile.domain.repository.ReservationRepository
import com.waf.servicentromobile.domain.repository.VehicleRepository

object MemoryDataRepository : VehicleRepository, ReservationRepository, CarServiceRepository {

    private val vehiclesList = mutableListOf<Vehicle>()
    private val reservationsList = mutableListOf<Reservation>()
    private val carServicesList = mutableListOf<CarService>()

    // --- VEHICLES ---
    override fun getVehicles(): List<Vehicle> = vehiclesList

    override fun addVehicle(vehicle: Vehicle) {
        vehiclesList.add(vehicle)
    }

    override fun updateVehicle(vehicle: Vehicle) {
        val index = vehiclesList.indexOfFirst { it.id == vehicle.id }
        if (index != -1) {
            vehiclesList[index] = vehicle
        }
    }

    override fun deleteVehicle(vehicleId: String) {
        vehiclesList.removeIf { it.id == vehicleId }
    }

    // --- RESERVATIONS ---
    override fun getReservations(): List<Reservation> = reservationsList

    override fun addReservation(reservation: Reservation) {
        reservationsList.add(reservation)
    }

    override fun updateReservationStatus(reservationId: String, status: String) {
        val index = reservationsList.indexOfFirst { it.id == reservationId }
        if (index != -1) {
            reservationsList[index] = reservationsList[index].copy(status = status)
        }
    }

    override fun deleteReservation(reservationId: String) {
        reservationsList.removeIf { it.id == reservationId }
    }

    // --- CAR SERVICES ---
    override fun getAllServices(): List<CarService> = carServicesList

    override fun addService(service: CarService) {
        carServicesList.add(service)
    }

    override fun updateService(id: String, updatedService: CarService) {
        val index = carServicesList.indexOfFirst { it.id == id }
        if (index != -1) {
            carServicesList[index] = updatedService
        }
    }

    override fun deleteService(id: String) {
        carServicesList.removeIf { it.id == id }
    }
}