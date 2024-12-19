package com.example.avanceproyectov2.contabilidad

data class Factura(
    val id: String = "",
    val nombreCliente: String,
    val cantidad: Int,
    val precioFijo: Double = 0.80,
    val impuesto: Double = 0.15,
    val total: Double
)