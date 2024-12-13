// GestionClientes.kt
package com.example.avanceproyectov2.gestion

import com.example.avanceproyectov2.clases.Cliente

class GestionClientes {
    private val clientes = mutableListOf<Cliente>()

    fun agregarCliente(cliente: Cliente) {
        clientes.add(cliente)
    }

    fun actualizarCliente(cliente: Cliente) {
        val index = clientes.indexOfFirst { it.id == cliente.id }
        if (index != -1) {
            clientes[index] = cliente
        }
    }

    fun obtenerClientes(): List<Cliente> = clientes
}
