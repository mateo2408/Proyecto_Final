// PantallaPrincipal.kt
package com.example.avanceproyectov2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaPrincipal(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { navController.navigate("pantallaPedidos") }) {
            Text(text = "Pedidos")
        }
        Button(onClick = { navController.navigate("pantallaRutas") }) {
            Text(text = "Rutas")
        }
        Button(onClick = { navController.navigate("pantallaMapa") }) {
            Text(text = "Mapa")
        }
        Button(onClick = { navController.navigate("pantallaNavegacion") }) {
            Text(text = "Navegación")
        }
        Button(onClick = { navController.navigate("pantallaInicioSesion") }) {
            Text(text = "Inicio Sesión")
        }
        Button(onClick = { navController.navigate("pantallaRegistrar") }) {
            Text(text = "Registrar")
        }
    }
}