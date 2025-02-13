package com.example.avanceproyectov2.pantallas

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.avanceproyectov2.gestion.GestionPedidos
import com.example.avanceproyectov2.clases.Pedido
import com.example.avanceproyectov2.clases.SelectLocationActivity
import com.example.avanceproyectov2.firebase.compareCedula
import com.example.avanceproyectov2.firebase.fetchPedidosByCedula
import com.example.avanceproyectov2.firebase.savePedido

@Composable
fun PantallaPedidos(navController: NavController, gestionPedidos: GestionPedidos) {
    var descripcion by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("") }
    var nombreCliente by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }
    var cantidadProductos by remember { mutableStateOf("") }
    var ruta by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var searchCedula by remember { mutableStateOf("") }
    var selectedPedido by remember { mutableStateOf<Pedido?>(null) }
    val pedidos = remember { mutableStateListOf<Pedido>() }
    LaunchedEffect(Unit) {
        gestionPedidos.obtenerPedidos { pedidosList ->
            pedidos.clear()
            pedidos.addAll(pedidosList)
        }
    }

    val activity = LocalContext.current as Activity
    val locationRequestCode = 1

    Scaffold(
        topBar = { AppBar(title = "Pedidos") }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            TextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = estado,
                onValueChange = { estado = it },
                label = { Text("Estado") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = nombreCliente,
                onValueChange = { nombreCliente = it },
                label = { Text("Nombre del Cliente") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = cedula,
                onValueChange = { cedula = it },
                label = { Text("Cedula") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    val intent = Intent(activity, SelectLocationActivity::class.java)
                    activity.startActivityForResult(intent, locationRequestCode)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Seleccionar Ubicación")
            }
            TextField(
                value = cantidadProductos,
                onValueChange = { cantidadProductos = it },
                label = { Text("Cantidad de Productos") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = ruta,
                onValueChange = { ruta = it },
                label = { Text("Ruta") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    val pedido = Pedido(
                        id = selectedPedido?.id ?: "",
                        descripcion = descripcion,
                        estado = estado,
                        nombreCliente = nombreCliente,
                        ubicacion = ubicacion,
                        cantidadProductos = cantidadProductos,
                        ruta = ruta,
                        cedula = cedula
                    )
                    if (selectedPedido == null) {
                        savePedido(pedido, cedula) { success ->
                            if (success) {
                                pedidos.add(pedido)
                                descripcion = ""
                                estado = ""
                                nombreCliente = ""
                                ubicacion = ""
                                cantidadProductos = ""
                                ruta = ""
                                cedula = ""
                            }
                        }
                    } else {
                        gestionPedidos.actualizarPedido(pedido) { success ->
                            if (success) {
                                val index = pedidos.indexOfFirst { it.id == pedido.id }
                                if (index != -1) {
                                    pedidos[index] = pedido
                                }
                                selectedPedido = null
                                descripcion = ""
                                estado = ""
                                nombreCliente = ""
                                ubicacion = ""
                                cantidadProductos = ""
                                ruta = ""
                                cedula = ""
                            }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (selectedPedido == null) "Agregar Pedido" else "Actualizar Pedido")
            }
            TextField(
                value = searchCedula,
                onValueChange = { searchCedula = it },
                label = { Text("Buscar por Cedula") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
    onClick = {
        compareCedula(searchCedula) { userExists, userName ->
            if (userExists) {
                fetchPedidosByCedula(searchCedula) { fetchedPedidos ->
                    pedidos.clear()
                    pedidos.addAll(fetchedPedidos)
                    nombreCliente = userName ?: ""
                }
            } else {
                pedidos.clear()
                nombreCliente = ""
            }
        }
    },
    modifier = Modifier.fillMaxWidth()
) {
    Text("Buscar")
}
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(pedidos) { pedido ->
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = "Pedido: ${pedido.descripcion}", style = MaterialTheme.typography.headlineSmall)
                        Text(text = "Estado: ${pedido.estado}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "Cliente: ${pedido.nombreCliente}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "Ubicación: ${pedido.ubicacion}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "Cantidad: ${pedido.cantidadProductos}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "Ruta: ${pedido.ruta}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "Cedula: ${pedido.cedula}", style = MaterialTheme.typography.bodyLarge)
                        Button(onClick = {
                            selectedPedido = pedido
                            descripcion = pedido.descripcion
                            estado = pedido.estado
                            nombreCliente = pedido.nombreCliente
                            ubicacion = pedido.ubicacion
                            cantidadProductos = pedido.cantidadProductos
                            ruta = pedido.ruta
                            cedula = pedido.cedula
                        }) {
                            Text("Editar")
                        }
                    }
                }
            }
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Regresar")
            }
        }
    }

    val resultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val location = result.data?.getStringExtra("location")
            if (location != null) {
                ubicacion = location
            }
        }
    }
}