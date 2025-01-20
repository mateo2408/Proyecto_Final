package com.example.avanceproyectov2.firebase

import com.google.firebase.firestore.FirebaseFirestore

fun compareCedula(cedula: String, onComplete: (Boolean) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("users").whereEqualTo("cedula", cedula).get()
        .addOnSuccessListener { result ->
            onComplete(!result.isEmpty)
        }
        .addOnFailureListener {
            onComplete(false)
        }
}