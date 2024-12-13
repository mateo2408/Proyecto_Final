package com.example.avanceproyectov2.pantallas

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.avanceproyectov2.clases.User
import com.example.avanceproyectov2.firebase.registerUser
import com.example.avanceproyectov2.firebase.saveUserData

@Composable
fun PantallaRegistrar(navController: NavController) {
    val context = LocalContext.current
    val nombre = remember { mutableStateOf("") }
    val cedula = remember { mutableStateOf("") }
    val correo = remember { mutableStateOf("") }
    val telefono = remember { mutableStateOf("") }
    val contra = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Registro de Usuario")

        OutlinedTextField(
            value = nombre.value,
            onValueChange = { nombre.value = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = cedula.value,
            onValueChange = { cedula.value = it },
            label = { Text("Cédula") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = correo.value,
            onValueChange = { correo.value = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = telefono.value,
            onValueChange = { telefono.value = it },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = contra.value,
            onValueChange = { contra.value = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Button(
            onClick = {
                if (nombre.value.isNotEmpty() && cedula.value.isNotEmpty() && correo.value.isNotEmpty() && telefono.value.isNotEmpty() && contra.value.isNotEmpty()) {
                    if (contra.value.length >= 6) {
                        registerUser(correo.value, contra.value) { success ->
                            if (success) {
                                val user = User(nombre.value, cedula.value, correo.value, telefono.value)
                                saveUserData(user) { saveSuccess ->
                                    if (saveSuccess) {
                                        Toast.makeText(context, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
                                        navController.navigate("pantallaPrincipal") {
                                            popUpTo("pantallaPrincipal") { inclusive = true }
                                        }
                                    } else {
                                        Toast.makeText(context, "Error al guardar datos", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            } else {
                                Toast.makeText(context, "Error en el registro", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(context, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Registrar")
        }

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Regresar")
        }
    }
}