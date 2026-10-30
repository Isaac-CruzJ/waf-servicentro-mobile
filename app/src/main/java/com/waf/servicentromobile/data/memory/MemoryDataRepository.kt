package com.waf.servicentromobile.data.memory

import com.waf.servicentromobile.domain.model.Reservation
import com.waf.servicentromobile.domain.model.Vehicle
import com.waf.servicentromobile.domain.repository.ReservationRepository
import com.waf.servicentromobile.domain.repository.VehicleRepository

class MemoryDataRepository : VehicleRepository, ReservationRepository {

    private val vehiclesList = mutableListOf<Vehicle>()
    private val reservationsList = mutableListOf<Reservation>()

    override fun getVehicles(): List<Vehicle> = vehiclesList

    override fun addVehicle(vehicle: Vehicle) {
        vehiclesList.add(vehicle)
    }

    override fun updateVehicle(vehicle: Vehicle) {
        val index = vehiclesList.indexOfFirst { it.id == vehicle.id }
        if (index != -1) { vehiclesList[index] = vehicle }
    }

    override fun deleteVehicle(vehicleId: String) {
        vehiclesList.removeIf { it.id == vehicleId }
    }

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
}