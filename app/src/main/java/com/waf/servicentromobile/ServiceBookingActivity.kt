package com.waf.servicentromobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * ServiceBookingActivity handles the reservation process for vehicle maintenance services,
 * validating booking parameters and confirming entries.
 */
class ServiceBookingActivity : AppCompatActivity() {

    private lateinit var etServiceName: EditText
    private lateinit var etBookingDate: EditText
    private lateinit var btnConfirmBooking: Button
    private lateinit var btnCancelBooking: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_booking)

        // Vinculación de elementos de la interfaz gráfica
        etServiceName = findViewById(R.id.etServiceName)
        etBookingDate = findViewById(R.id.etBookingDate)
        btnConfirmBooking = findViewById(R.id.btnConfirmBooking)
        btnCancelBooking = findViewById(R.id.btnCancelBooking)

        // Configura la acción para confirmar la reserva
        btnConfirmBooking.setOnClickListener {
            val serviceName = etServiceName.text.toString().trim()
            val bookingDate = etBookingDate.text.toString().trim()

            if (serviceName.isEmpty() || bookingDate.isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_fill_fields), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Service booked successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        // Configura el botón de cancelar
        btnCancelBooking.setOnClickListener {
            finish()
        }
    }
}