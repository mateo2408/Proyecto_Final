// NavGraph.kt
package com.example.avanceproyectov2

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController,
    gestionPedidos: GestionPedidos,
    gestionRutas: GestionRutas,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = "pantallaPrincipal", modifier = modifier) {
        composable("pantallaPrincipal") { PantallaPrincipal(navController) }
        composable("pantallaInicioSesion") { PantallaInicioSesion(navController) }
        composable("pantallaPedidos") { PantallaPedidos(navController, gestionPedidos) }
        composable("pantallaRutas") { PantallaRutas(navController, gestionRutas) }
        composable("pantallaMapa") { PantallaMapa(navController) }
        composable("pantallaNavegacion") { PantallaNavegacion(navController) }
        composable("pantallaRegistrar") { PantallaRegistrar(navController) }
        composable("pantallaLogin") { PantallaLogin(navController) }
    }
}