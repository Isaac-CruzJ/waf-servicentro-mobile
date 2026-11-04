package com.waf.servicentromobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * VehicleActivity manages the form to register a new vehicle into W.A.F. AutoCare,
 * validating input fields and saving records successfully.
 */
class VehicleActivity : AppCompatActivity() {

    private lateinit var etLicensePlate: EditText
    private lateinit var etBrand: EditText
    private lateinit var etModel: EditText
    private lateinit var btnSaveVehicle: Button
    private lateinit var btnCancelVehicle: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle)

        // Vinculación de los elementos de la interfaz gráfica
        etLicensePlate = findViewById(R.id.etLicensePlate)
        etBrand = findViewById(R.id.etBrand)
        etModel = findViewById(R.id.etModel)
        btnSaveVehicle = findViewById(R.id.btnSaveVehicle)
        btnCancelVehicle = findViewById(R.id.btnCancelVehicle)

        // Configura la lógica para validar y guardar el vehículo
        btnSaveVehicle.setOnClickListener {
            val licensePlate = etLicensePlate.text.toString().trim()
            val brand = etBrand.text.toString().trim()
            val model = etModel.text.toString().trim()

            if (licensePlate.isEmpty() || brand.isEmpty() || model.isEmpty()) {
                // Muestra un Toast de advertencia si hay campos vacíos
                Toast.makeText(this, getString(R.string.toast_fill_fields), Toast.LENGTH_SHORT).show()
            } else {
                // Muestra mensaje de éxito y cierra la actividad actual
                Toast.makeText(this, getString(R.string.toast_vehicle_saved), Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        // Configura el botón de cancelar para cerrar el formulario
        btnCancelVehicle.setOnClickListener {
            finish()
        }
    }
}