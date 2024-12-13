import com.example.avanceproyectov2.User
import com.google.firebase.firestore.FirebaseFirestore

data class User(val nombre: String, val cedula: String, val correo: String, val telefono: String)

fun saveUserData(user: User, onComplete: (Boolean) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("users").document(user.cedula)
        .set(user)
        .addOnCompleteListener { task ->
            onComplete(task.isSuccessful)
        }
}