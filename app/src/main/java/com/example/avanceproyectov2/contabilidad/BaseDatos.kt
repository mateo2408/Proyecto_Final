package com.example.avanceproyectov2.contabilidad

import com.google.firebase.firestore.FirebaseFirestore

fun guardarFactura(factura: Factura, onComplete: (Boolean) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("facturas")
        .add(factura)
        .addOnSuccessListener { onComplete(true) }
        .addOnFailureListener { onComplete(false) }
}