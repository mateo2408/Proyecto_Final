// PantallaMapa.kt
package com.example.avanceproyectov2.pantallas

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.avanceproyectov2.clases.SelectLocationActivity

@Composable
fun PantallaMapa(navController: NavController) {
    val activity = LocalContext.current as Activity
    val locationRequestCode = 1

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Mapa")
        Button(
            onClick = {
                val intent = Intent(activity, SelectLocationActivity::class.java)
                activity.startActivityForResult(intent, locationRequestCode)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver mapa de rutas")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Regresar")
        }
    }
}