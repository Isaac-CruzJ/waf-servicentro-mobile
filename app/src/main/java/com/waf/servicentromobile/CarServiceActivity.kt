package com.waf.servicentromobile

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.waf.servicentromobile.data.memory.MemoryDataRepository
import com.waf.servicentromobile.domain.model.CarService
import java.util.UUID

class CarServiceActivity : AppCompatActivity() {

    private lateinit var etServiceName: EditText
    private lateinit var etServiceDescription: EditText
    private lateinit var spinnerVehicles: Spinner
    private lateinit var btnSaveService: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_service)

        etServiceName = findViewById(R.id.etServiceName)
        etServiceDescription = findViewById(R.id.etServiceDescription)
        spinnerVehicles = findViewById(R.id.spinnerVehicles)
        btnSaveService = findViewById(R.id.btnSaveService)

        loadVehiclesIntoSpinner()

        btnSaveService.setOnClickListener {
            val name = etServiceName.text.toString().trim()
            val description = etServiceDescription.text.toString().trim()
            val selectedVehicle = spinnerVehicles.selectedItem?.toString() ?: ""

            if (name.isEmpty() || description.isEmpty() || selectedVehicle.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Creamos el servicio
            val newService = CarService(
                id = UUID.randomUUID().toString(),
                name = name,
                description = description,
                assignedVehiclePlate = selectedVehicle
            )

            // Guardamos directamente usando el objeto global MemoryDataRepository
            MemoryDataRepository.addService(newService)

            Toast.makeText(this, "Service saved successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun loadVehiclesIntoSpinner() {
        // Obtenemos los vehículos del repositorio global
        val vehicles = MemoryDataRepository.getVehicles()
        val vehiclePlates = vehicles.map { it.licensePlate }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, vehiclePlates)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerVehicles.adapter = adapter
    }
}