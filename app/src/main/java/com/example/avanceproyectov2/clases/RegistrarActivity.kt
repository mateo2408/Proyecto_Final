// PantallaRegistrar.kt
package com.example.avanceproyectov2.clases

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHostController
import com.example.avanceproyectov2.R

class RegistrarActivity(navController: NavHostController) : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etCedula: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etContra: EditText
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        etNombre = findViewById(R.id.et_nombre)
        etCedula = findViewById(R.id.et_cedula)
        etCorreo = findViewById(R.id.et_correo)
        etTelefono = findViewById(R.id.et_telefono)
        etContra = findViewById(R.id.et_contra)
        btnRegistrar = findViewById(R.id.btn_registrar)

        btnRegistrar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val cedula = etCedula.text.toString()
            val correo = etCorreo.text.toString()
            val telefono = etTelefono.text.toString()
            val contra = etContra.text.toString()

            if (nombre.isNotEmpty() && cedula.isNotEmpty() && correo.isNotEmpty() && telefono.isNotEmpty()) {
                saveUserData(nombre, cedula, correo, telefono)
                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveUserData(nombre: String, cedula: String, correo: String, telefono: String) {
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("nombre", nombre)
        editor.putString("cedula", cedula)
        editor.putString("correo", correo)
        editor.putString("telefono", telefono)
        editor.apply()
    }
}