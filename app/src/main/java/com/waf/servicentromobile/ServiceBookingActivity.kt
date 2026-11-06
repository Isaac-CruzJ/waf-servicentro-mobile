package com.waf.servicentromobile

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class ServiceBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_booking)

        val etServiceName = findViewById<EditText>(R.id.etServiceName)
        val tvBookingDate = findViewById<TextView>(R.id.tvBookingDate)
        val btnSelectDate = findViewById<ImageButton>(R.id.btnSelectDate)
        val btnConfirmBooking = findViewById<Button>(R.id.btnConfirmBooking)
        val btnCancelBooking = findViewById<Button>(R.id.btnCancelBooking)

        // Configurar el selector de fecha al hacer clic en el botón de calendario o en el texto
        btnSelectDate.setOnClickListener {
            showDatePickerDialog(tvBookingDate)
        }
        tvBookingDate.setOnClickListener {
            showDatePickerDialog(tvBookingDate)
        }

        btnConfirmBooking.setOnClickListener {
            val serviceName = etServiceName.text.toString().trim()
            val bookingDate = tvBookingDate.text.toString().trim()

            if (serviceName.isEmpty() || bookingDate.isEmpty() || bookingDate == "DD/MM/YYYY") {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Service booked successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btnCancelBooking.setOnClickListener {
            finish()
        }
    }

    private fun showDatePickerDialog(tvBookingDate: TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear)
                tvBookingDate.setText(formattedDate)
            },
            year,
            month,
            day
        )


        datePickerDialog.datePicker.minDate = calendar.timeInMillis

        datePickerDialog.show()
    }
}