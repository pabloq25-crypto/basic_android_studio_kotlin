package com.quirozdev.androidmaster.sintaxis

fun main() {
    // inmutableList()
    mutableList() //Acá podemos modificar o añadir valores a diferencia de la otra lista

}

fun inmutableList() {
    val readOnly : List<String> = listOf("Lunes","Martes","Miércoles", "Jueves", "Viernes","Sábado","Domingo")

    // println(readOnly.size)
    // println(readOnly)
    // println(readOnly[0])
    // println(readOnly.last())
    // println(readOnly.first())

    // val example = readOnly.filter { it.contains("A") }
    // println(example)

    // readOnly.forEach { println(it) }
    readOnly.forEach { weekDay -> println(weekDay) }
}

fun mutableList() {
    var weekDays:MutableList<String> = mutableListOf("Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo")
    weekDays.add(0,"PabloDay")
    println(weekDays)

    if(weekDays.isEmpty())
        //Nada
    else
        weekDays.forEach { println(it) }

    if(weekDays.isNotEmpty()) {
        weekDays.forEach { println(it) }
    }

    weekDays.last()
}