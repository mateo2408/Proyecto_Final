package com.example.avanceproyectov2.firebase

import com.example.avanceproyectov2.clases.Pedido
import com.google.firebase.firestore.FirebaseFirestore

fun fetchPedidosByCedula(cedula: String, onComplete: (List<Pedido>) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("pedidos").whereEqualTo("cedula", cedula).get()
        .addOnSuccessListener { result ->
            val pedidos = result.map { document ->
                Pedido(
                    id = document.id,
                    descripcion = document.getString("descripcion") ?: "",
                    estado = document.getString("estado") ?: "",
                    nombreCliente = document.getString("nombreCliente") ?: "",
                    ubicacion = document.getString("ubicacion") ?: "",
                    cantidadProductos = document.getString("cantidadProductos") ?: "",
                    ruta = document.getString("ruta") ?: "",
                    cedula = document.getString("cedula") ?: ""
                )
            }
            onComplete(pedidos)
        }
        .addOnFailureListener {
            onComplete(emptyList())
        }
}