// Algoritmos.kt
package com.example.avanceproyectov2.algoritmo

import com.example.avanceproyectov2.clases.Pedido

fun buscarPedidoPorId(pedidos: List<Pedido>, id: String): Pedido? {
    return pedidos.find { it.id == id }
}

fun ordenarPedidosPorEstado(pedidos: List<Pedido>): List<Pedido> {
    return pedidos.sortedBy { it.estado }
}