package com.example.avanceproyectov2.pantallas

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.avanceproyectov2.contabilidad.Factura
import com.example.avanceproyectov2.contabilidad.calcularTotal
import com.example.avanceproyectov2.contabilidad.guardarFactura

@Composable
fun PantallaFactura(navController: NavController) {
    val context = LocalContext.current
    var nombreCliente by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Generar Factura")

        OutlinedTextField(
            value = nombreCliente,
            onValueChange = { nombreCliente = it },
            label = { Text("Nombre del Cliente") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Button(
            onClick = {
                val cantidadInt = cantidad.toIntOrNull()
                if (nombreCliente.isNotEmpty() && cantidadInt != null) {
                    val total = calcularTotal(cantidadInt, 0.80, 0.15)
                    val factura = Factura(
                        nombreCliente = nombreCliente,
                        cantidad = cantidadInt,
                        total = total
                    )
                    guardarFactura(factura) { success ->
                        if (success) {
                            Toast.makeText(context, "Factura guardada exitosamente", Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        } else {
                            Toast.makeText(context, "Error al guardar la factura", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(context, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Generar Factura")
        }
    }
}