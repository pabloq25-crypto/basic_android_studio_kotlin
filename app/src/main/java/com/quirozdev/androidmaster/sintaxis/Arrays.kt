package com.quirozdev.androidmaster.sintaxis

fun main() {
    val weekDays = arrayOf("Lunes","Martes","Miércoles", "Jueves", "Viernes","Sábado","Domingo")
    // println(weekDays[0])
    // println(weekDays.size)

    if(weekDays.size >= 8) println(weekDays[7])
    else println("No hay más valores en el array")

    // Modificar valores
    //weekDays[0] = "Holita2"
    // println(weekDays[0])

    // Bucles para Arrays
    /* for (position in weekDays.indices){
        println(weekDays[position])
    } */

    for((position,value) in weekDays.withIndex()) {
        // println("La posición $position contiene $value")
    }

    for (SUSCRIBETE in weekDays) {
        println("Ahora es: $SUSCRIBETE")
    }
}