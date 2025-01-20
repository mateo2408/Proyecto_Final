package com.example.avanceproyectov2.clases

data class Pedido(
    val id: String = "",
    val descripcion: String,
    val estado: String,
    val nombreCliente: String,
    val ubicacion: String,
    val cantidadProductos: String,
    val ruta: String,
    val cedula: String
)