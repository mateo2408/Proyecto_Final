package com.example.avanceproyectov2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaRutas(navController: NavController, gestionRutas: GestionRutas) {
    val rutas = listOf("1", "2", "3")
    val camiones = listOf("Camión 1", "Camión 2", "Camión 3", "Camión 4", "Camión 5")
    val pedidos = remember { mutableStateListOf<Pedido>() }
    val rutaSeleccionada = remember { mutableStateOf("") }
    val camionSeleccionado = remember { mutableStateOf("") }
    val camionesEnRuta = remember { mutableStateMapOf<String, String>() }

    LaunchedEffect(Unit) {
        gestionRutas.obtenerPedidos { pedidosList ->
            pedidos.clear()
            pedidos.addAll(pedidosList)
        }
    }

    Scaffold(
        topBar = { AppBar(title = "Rutas") }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            Text("Selecciona una Ruta", style = MaterialTheme.typography.headlineSmall)
            rutas.forEach { ruta ->
                Button(
                    onClick = { rutaSeleccionada.value = ruta },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                    Text(ruta)
                }
            }
            if (rutaSeleccionada.value.isNotEmpty()) {
                val clientesEnRuta = pedidos.count { it.ruta == rutaSeleccionada.value }
                Text("Clientes en Ruta ${rutaSeleccionada.value}: $clientesEnRuta", style = MaterialTheme.typography.bodyLarge)
                Text("Selecciona un Camión", style = MaterialTheme.typography.headlineSmall)
                camiones.forEach { camion ->
                    Button(
                        onClick = {
                            camionSeleccionado.value = camion
                            camionesEnRuta[camion] = rutaSeleccionada.value
                        },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                    ) {
                        Text(camion)
                    }
                }
                if (camionSeleccionado.value.isNotEmpty()) {
                    Text("Camión Seleccionado: ${camionSeleccionado.value}", style = MaterialTheme.typography.bodyLarge)
                }
            }
            Text("Camiones y sus Rutas", style = MaterialTheme.typography.headlineSmall)
            camionesEnRuta.forEach { (camion, ruta) ->
                Text("$camion - Ruta $ruta", style = MaterialTheme.typography.bodyLarge)
            }
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Regresar")
            }
        }
    }
}