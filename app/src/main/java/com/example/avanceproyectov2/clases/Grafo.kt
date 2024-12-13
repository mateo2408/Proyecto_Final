// Grafo.kt
package com.example.avanceproyectov2.clases

class Grafo {
    private val adyacencias: MutableMap<String, MutableList<String>> = mutableMapOf()

    fun agregarArista(origen: String, destino: String) {
        adyacencias.computeIfAbsent(origen) { mutableListOf() }.add(destino)
    }

    fun obtenerAdyacencias(nodo: String): List<String> {
        return adyacencias[nodo] ?: emptyList()
    }
}