package com.example.avanceproyectov2.firebase

import com.google.firebase.auth.FirebaseAuth

fun registerUser(email: String, password: String, onComplete: (Boolean) -> Unit) {
    val auth = FirebaseAuth.getInstance()
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            onComplete(task.isSuccessful)
        }
}