package com.waf.servicentromobile.viewmodel

import androidx.lifecycle.ViewModel
import com.waf.servicentromobile.data.memory.MemoryDataRepository
import com.waf.servicentromobile.domain.model.Reservation

class ReservationViewModel : ViewModel() {
    private val repository = MemoryDataRepository()

    fun getReservations(): List<Reservation> = repository.getReservations()

    fun addNewReservation(id: String, vehicleId: String, serviceId: String, date: String) {
        repository.addReservation(Reservation(id, vehicleId, serviceId, date, "Pending"))
    }

    fun removeReservation(id: String) {
        repository.deleteReservation(id)
    }
}