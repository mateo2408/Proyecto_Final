package com.example.avanceproyectov2.contabilidad

fun calcularTotal(cantidad: Int, precioFijo: Double, impuesto: Double): Double {
    val subtotal = cantidad * precioFijo
    val totalImpuesto = subtotal * impuesto
    return subtotal + totalImpuesto
}