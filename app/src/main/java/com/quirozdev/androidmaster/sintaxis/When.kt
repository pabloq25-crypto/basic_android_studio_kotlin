package com.quirozdev.androidmaster.sintaxis

fun main() {
    // getMonth(11)
    // getTrimester(5)
    print(getSemester(5))
    //result("5")
}

fun result(value:Any) {
    when(value) {
        is Int -> print(value + value)
        is String -> println(value)
        is Boolean -> if(value) print("Holiwi")
    }
}

fun getSemester(month:Int) = when(month) {
        in 1..6 -> "Primer Semestre"
        in 7..12 -> "Segundo Semestre"
        !in 1..12 -> "Semestre no válido"
        else -> "dawda"
}

fun getTrimester(month:Int) {
    when(month) {
        1,2,3 -> print("Primer Trimestre")
        4,5,6 -> print("Segundo Trimestre")
        7,8,9 -> print("Tercer Trimestre")
        10,11,12 -> print("Cuarto Trimestre")
        else -> print("Trimestre no válido")
    }
}

fun getMonth(month:Int) {
    when(month) {
        1 -> print("Enero")
        2 -> print("Febrero")
        3 -> print("Marzo")
        4 -> print("Abril")
        5 -> print("Mayo")
        6 -> print("Junio")
        7 -> print("Julio")
        8 -> print("Agosto")
        9 -> print("Septiembre")
        10 -> print("Octubre")
        11 -> {
            println("Noviembre")
            print("Noviembre")
        }
        12 -> print("Diciembre")
        else -> println("No es un mes válido")
    }
}

