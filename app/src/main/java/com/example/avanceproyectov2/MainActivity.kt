// MainActivity.kt
package com.example.avanceproyectov2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.avanceproyectov2.gestion.GestionPedidos
import com.example.avanceproyectov2.gestion.GestionRutas
import com.example.avanceproyectov2.pantallas.NavGraph
import com.example.avanceproyectov2.ui.theme.AvanceProyectoTheme
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivity : ComponentActivity() {

    private val gestionPedidos = GestionPedidos()
    private val gestionRutas = GestionRutas()

    override fun onCreate(savedInstanceState: Bundle?) {
        //llkdldkdlskdlskdlskdl
        super.onCreate(savedInstanceState)
        Firebase.initialize(this)
        setContent {
            MyApp(gestionPedidos, gestionRutas)
        }
    }
}

@Composable
fun MyApp(gestionPedidos: GestionPedidos, gestionRutas: GestionRutas) {
    AvanceProyectoTheme {
        val navController = rememberNavController()
        Scaffold { innerPadding ->
            NavGraph(
                navController = navController,
                gestionPedidos = gestionPedidos,
                gestionRutas = gestionRutas,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val gestionPedidos = GestionPedidos()
    val gestionRutas = GestionRutas()
    MyApp(gestionPedidos, gestionRutas)
}