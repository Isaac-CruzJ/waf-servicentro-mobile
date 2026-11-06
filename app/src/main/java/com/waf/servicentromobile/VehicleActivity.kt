package com.waf.servicentromobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.waf.servicentromobile.data.memory.MemoryDataRepository
import com.waf.servicentromobile.domain.model.Vehicle
import java.util.UUID

class VehicleActivity : AppCompatActivity() {

    private lateinit var etLicensePlate: EditText
    private lateinit var etBrand: EditText
    private lateinit var etModel: EditText
    private lateinit var btnSave: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button
    private lateinit var btnClear: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle)

        etLicensePlate = findViewById(R.id.etLicensePlate)
        etBrand = findViewById(R.id.etBrand)
        etModel = findViewById(R.id.etModel)
        btnSave = findViewById(R.id.btnSave)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        btnClear = findViewById(R.id.btnClear)
        btnBack = findViewById(R.id.btnBack)

        // 1. Botón Guardar (Save)
        btnSave.setOnClickListener {
            val plate = etLicensePlate.text.toString().trim()
            val brand = etBrand.text.toString().trim()
            val model = etModel.text.toString().trim()

            if (plate.isEmpty() || brand.isEmpty() || model.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validar si ya existe una placa igual usando el repositorio global
            val existingVehicle = MemoryDataRepository.getVehicles().find { it.licensePlate.equals(plate, ignoreCase = true) }
            if (existingVehicle != null) {
                Toast.makeText(this, "Vehicle with this plate already exists", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newVehicle = Vehicle(
                id = UUID.randomUUID().toString(),
                licensePlate = plate,
                brand = brand,
                model = model
            )

            MemoryDataRepository.addVehicle(newVehicle)
            Toast.makeText(this, "Vehicle saved successfully", Toast.LENGTH_SHORT).show()
            clearFields()
        }

        // 2. Botón Actualizar (Update) con validación previa
        btnUpdate.setOnClickListener {
            val plate = etLicensePlate.text.toString().trim()
            val brand = etBrand.text.toString().trim()
            val model = etModel.text.toString().trim()

            if (plate.isEmpty()) {
                Toast.makeText(this, "Please enter the license plate to update", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Buscar si el vehículo ya fue previamente agregado
            val existingVehicle = MemoryDataRepository.getVehicles().find { it.licensePlate.equals(plate, ignoreCase = true) }

            if (existingVehicle == null) {
                Toast.makeText(this, "That vehicle is not available, please save it first", Toast.LENGTH_LONG).show()
            } else {
                val updatedVehicle = existingVehicle.copy(
                    brand = if (brand.isNotEmpty()) brand else existingVehicle.brand,
                    model = if (model.isNotEmpty()) model else existingVehicle.model
                )
                MemoryDataRepository.updateVehicle(updatedVehicle)
                Toast.makeText(this, "Vehicle updated successfully", Toast.LENGTH_SHORT).show()
                clearFields()
            }
        }

        // 3. Botón Eliminar (Delete)
        btnDelete.setOnClickListener {
            val plate = etLicensePlate.text.toString().trim()

            if (plate.isEmpty()) {
                Toast.makeText(this, "Please enter the license plate to delete", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val existingVehicle = MemoryDataRepository.getVehicles().find { it.licensePlate.equals(plate, ignoreCase = true) }

            if (existingVehicle == null) {
                Toast.makeText(this, "That vehicle is not available", Toast.LENGTH_SHORT).show()
            } else {
                MemoryDataRepository.deleteVehicle(existingVehicle.id)
                Toast.makeText(this, "Vehicle deleted successfully", Toast.LENGTH_SHORT).show()
                clearFields()
            }
        }

        // 4. Botón Limpiar (Clear / Cancel)
        btnClear.setOnClickListener {
            clearFields()
            Toast.makeText(this, "Fields cleared", Toast.LENGTH_SHORT).show()
        }

        // 5. Botón Volver Atrás (Back to Menu)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }

    private fun clearFields() {
        etLicensePlate.text.clear()
        etBrand.text.clear()
        etModel.text.clear()
    }
}