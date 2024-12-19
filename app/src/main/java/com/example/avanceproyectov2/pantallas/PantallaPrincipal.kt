// PantallaPrincipal.kt
package com.example.avanceproyectov2.pantallas

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.avanceproyectov2.gestion.GestionPedidos
import com.example.avanceproyectov2.gestion.GestionRutas

@Composable
fun PantallaPrincipal(navController: NavController, gestionPedidos: GestionPedidos, gestionRutas: GestionRutas) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center) {
        Button(onClick = {
            Log.d("PantallaPrincipal", "Navigating to pantallaPedidos")
            navController.navigate("pantallaPedidos")
        }) {
            Text(text = "Pedidos")
        }
        Button(onClick = {
            Log.d("PantallaPrincipal", "Navigating to pantallaRutas")
            navController.navigate("pantallaRutas")
        }) {
            Text(text = "Rutas")
        }
        Button(onClick = {
            Log.d("PantallaPrincipal", "Navigating to pantallaMapa")
            navController.navigate("pantallaMapa")
        }) {
            Text(text = "Mapa")
        }
        Button(onClick = {
            Log.d("PantallaPrincipal", "Navigating to pantallaNavegacion")
            navController.navigate("pantallaNavegacion")
        }) {
            Text(text = "Navegación")
        }
        Button(onClick = {
            Log.d("PantallaPrincipal", "Navigating to pantallaInicioSesion")
            navController.navigate("pantallaInicioSesion")
        }) {
            Text(text = "Inicio Sesión")
        }
        Button(onClick = {
            Log.d("PantallaPrincipal", "Navigating to pantallaRegistrar")
            navController.navigate("pantallaRegistrar")
        }) {
            Text(text = "Registrar")
        }
    }
}