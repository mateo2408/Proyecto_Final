// Algoritmos.kt
package com.example.avanceproyectov2

import com.example.avanceproyectov2.Pedido

fun buscarPedidoPorId(pedidos: List<Pedido>, id: String): Pedido? {
    return pedidos.find { it.id == id }
}

fun ordenarPedidosPorEstado(pedidos: List<Pedido>): List<Pedido> {
    return pedidos.sortedBy { it.estado }
}