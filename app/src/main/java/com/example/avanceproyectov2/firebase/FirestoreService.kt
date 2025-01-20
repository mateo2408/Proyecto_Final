package com.example.avanceproyectov2.firebase

import com.example.avanceproyectov2.clases.Pedido
import com.google.firebase.firestore.FirebaseFirestore

fun savePedido(pedido: Pedido, cedula: String, onComplete: (Boolean) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    val pedidoData = hashMapOf(
        "descripcion" to pedido.descripcion,
        "estado" to pedido.estado,
        "nombreCliente" to pedido.nombreCliente,
        "ubicacion" to pedido.ubicacion,
        "cantidadProductos" to pedido.cantidadProductos,
        "ruta" to pedido.ruta,
        "cedula" to cedula
    )
    db.collection("pedidos").add(pedidoData)
        .addOnSuccessListener { onComplete(true) }
        .addOnFailureListener { onComplete(false) }
}