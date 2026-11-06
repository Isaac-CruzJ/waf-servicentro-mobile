package com.waf.servicentromobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity acts as the primary dashboard for W.A.F. AutoCare,
 * enabling navigation toward vehicle registration, service booking, and service lists.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var btnAddVehicle: Button
    private lateinit var btnBookService: Button
    private lateinit var btnViewVehicles: Button // NUEVO
    private lateinit var btnViewServices: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components from the layout
        btnAddVehicle = findViewById(R.id.btnAddVehicle)
        btnBookService = findViewById(R.id.btnBookService)
        btnViewVehicles = findViewById(R.id.btnViewVehicles) // NUEVO
        btnViewServices = findViewById(R.id.btnViewServices)

        // Configura el evento para abrir la actividad de registro de vehículos
        btnAddVehicle.setOnClickListener {
            val intent = Intent(this, VehicleActivity::class.java)
            startActivity(intent)
        }

        // Configura la acción para navegar al formulario de reservas
        btnBookService.setOnClickListener {
            val intent = Intent(this, ServiceBookingActivity::class.java)
            startActivity(intent)
        }

        // NUEVO: Configura la acción para ver la lista de vehículos registrados
        btnViewVehicles.setOnClickListener {
            val intent = Intent(this, VehicleListActivity::class.java)
            startActivity(intent)
        }

        // Configura la acción para ver el listado general de servicios
        btnViewServices.setOnClickListener {
            val intent = Intent(this, ServiceListActivity::class.java)
            startActivity(intent)
        }
    }
}