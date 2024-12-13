// FirestoreService.kt
package com.example.avanceproyectov2.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.example.avanceproyectov2.clases.Pedido

fun savePedido(pedido: Pedido, onComplete: (Boolean) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("pedidos")
        .add(pedido)
        .addOnSuccessListener {
            onComplete(true)
        }
        .addOnFailureListener {
            onComplete(false)
        }
}