package com.example.avanceproyectov2.firebase

import com.google.firebase.firestore.FirebaseFirestore

fun compareCedula(cedula: String, onComplete: (Boolean, String?) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("users").whereEqualTo("cedula", cedula).get()
        .addOnSuccessListener { result ->
            if (!result.isEmpty) {
                val userName = result.documents[0].getString("nombre")
                onComplete(true, userName)
            } else {
                onComplete(false, null)
            }
        }
        .addOnFailureListener {
            onComplete(false, null)
        }
}