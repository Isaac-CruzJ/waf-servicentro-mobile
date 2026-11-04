package com.waf.servicentromobile.domain.repository

import com.waf.servicentromobile.domain.model.Reservation

interface ReservationRepository {
    fun getReservations(): List<Reservation>
    fun addReservation(reservation: Reservation)
    fun updateReservationStatus(reservationId: String, status: String)
    fun deleteReservation(reservationId: String)
}