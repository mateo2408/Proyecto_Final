// Cliente.kt
package com.example.avanceproyectov2

data class Cliente(
    val id: String,
    val nombre: String,
    val direccion: String,
    val pedidos: MutableList<Pedido>
)
