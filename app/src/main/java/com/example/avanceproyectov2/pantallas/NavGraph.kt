package com.example.avanceproyectov2.pantallas

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.avanceproyectov2.gestion.GestionPedidos
import com.example.avanceproyectov2.gestion.GestionRutas

@Composable
fun NavGraph(
    navController: NavHostController,
    gestionPedidos: GestionPedidos,
    gestionRutas: GestionRutas,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = "pantallaLogin", modifier = modifier) {
        composable("pantallaLogin") { PantallaLogin(navController) }
        composable("pantallaPrincipal") { PantallaPrincipal(navController, gestionPedidos, gestionRutas) }
        composable("pantallaRegistrar") { PantallaRegistrar(navController) }
        composable("pantallaPedidos") { PantallaPedidos(navController, gestionPedidos) }
        composable("pantallaRutas") { PantallaRutas(navController, gestionRutas) } // Corrected route name
        composable("pantallaMapa") { PantallaMapa(navController) }
        composable("pantallaNavegacion") { PantallaNavegacion(navController) }
        composable("pantallaInicioSesion") { PantallaInicioSesion(navController) }
    }
}