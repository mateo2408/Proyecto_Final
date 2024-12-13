// GestionPedidos.kt
package com.example.avanceproyectov2

class GestionPedidos {
    private val pedidos = mutableListOf<Pedido>()

    fun obtenerPedidos(callback: (List<Pedido>) -> Unit) {
        callback(pedidos)
    }

    fun agregarPedido(pedido: Pedido, callback: (Boolean) -> Unit) {
        pedidos.add(pedido)
        callback(true)
    }

    fun actualizarPedido(pedido: Pedido, callback: (Boolean) -> Unit) {
        val index = pedidos.indexOfFirst { it.id == pedido.id }
        if (index != -1) {
            pedidos[index] = pedido
            callback(true)
        } else {
            callback(false)
        }
    }
}