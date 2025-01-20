package com.example.avanceproyectov2.gestion

import com.example.avanceproyectov2.clases.Pedido

class GestionRutas {
    fun obtenerPedidos(callback: (List<Pedido>) -> Unit) {
        // Aquí se debe implementar la lógica para obtener los pedidos reales
        // Por ahora, se usa una lista de ejemplo
        val pedidosList = listOf(
            Pedido("1", "Pedido 1", "Pendiente", "Cliente 1", "Ubicación 1", "10", "1", "1"),
            Pedido("2", "Pedido 2", "Entregado", "Cliente 2", "Ubicación 2", "5", "2","2"),
            Pedido("3", "Pedido 3", "Pendiente", "Cliente 3", "Ubicación 3", "8", "3","3")
        )
        callback(pedidosList)
    }
}