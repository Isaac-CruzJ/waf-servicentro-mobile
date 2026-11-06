package com.waf.servicentromobile

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.waf.servicentromobile.data.memory.MemoryDataRepository

class VehicleListActivity : AppCompatActivity() {

    private lateinit var listViewVehicles: ListView
    private lateinit var btnBackToList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_list)

        listViewVehicles = findViewById(R.id.listViewVehicles)
        btnBackToList = findViewById(R.id.btnBackToList)

        loadVehicles()

        btnBackToList.setOnClickListener {
            finish()
        }
    }

    private fun loadVehicles() {
        // Obtenemos los vehículos directamente del objeto global en memoria
        val vehicles = MemoryDataRepository.getVehicles()

        // Creamos un formato de texto legible para cada vehículo
        val vehicleStrings = if (vehicles.isEmpty()) {
            listOf("No vehicles registered yet.")
        } else {
            vehicles.map { "Plate: ${it.licensePlate}\nBrand: ${it.brand} - Model: ${it.model}" }
        }

        // Usamos un ArrayAdapter tradicional para poblar la lista
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, vehicleStrings)
        listViewVehicles.adapter = adapter
    }
}