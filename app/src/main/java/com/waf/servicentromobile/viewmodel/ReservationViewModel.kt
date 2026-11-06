package com.waf.servicentromobile.viewmodel

import androidx.lifecycle.ViewModel
import com.waf.servicentromobile.data.memory.MemoryDataRepository
import com.waf.servicentromobile.domain.model.Reservation

class ReservationViewModel : ViewModel() {

    // Eliminamos la instanciación con paréntesis y usamos el objeto global directamente
    fun getReservations(): List<Reservation> {
        return MemoryDataRepository.getReservations()
    }

    fun addReservation(reservation: Reservation) {
        MemoryDataRepository.addReservation(reservation)
    }

    fun deleteReservation(reservationId: String) {
        MemoryDataRepository.deleteReservation(reservationId)
    }
}