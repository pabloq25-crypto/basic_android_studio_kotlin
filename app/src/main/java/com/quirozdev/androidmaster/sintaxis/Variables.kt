package  com.quirozdev.androidmaster.sintaxis

// VARIABLES



fun main() {
    val name = "Pablo"

    /**
     * Variables Numéricas
    */

    // Int
    val age:Int = 30
    var age2:Int = 40 //Val es una constante y var es una variable

    age2 = 29

    // Long
    val example:Long = 30

    //Float
    val floatExample:Float = 3.58f

    //Double
    val doubleExample:Double = 3241.413555

    print("Sumar: ")
    println(age + age2)

    println("Restar: ")
    println(age-age2)

    println("Multiplicar: ")
    println(age*age2)

    println("División")
    println(age/age2)

    println("Módulo")
    println(age % age2)



    /**
     * Variables Alfanuméricas
     */

    //Char
    val charExample1:Char = 'e'
    val charExample2:Char = '2'
    val charExample3:Char = '@'

    //String
    val stringExample:String = "adeqwqdwdw"


    /**
     * Variables Booleanas
     */

    //Boolean
    val booleanExample:Boolean = true
    val booleanExample2:Boolean = false


}