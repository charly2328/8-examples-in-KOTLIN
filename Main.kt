import java.util.*

fun main() {
    println("1. El siguiente programa llena un arreglo de 10 enteros y eleva al cuadrado cada numero elemento del arreglo.")
    println("2. Pide un numero entre en 1 y 9999 y nos dice cuantas unidades de millar, centenas, decenas y unidades tiene")
    println("3. Pide un numero en decimal y nos devuelve su equivalente en binario, octal y hexadecimal")
    println("4. El siguiente programa pide una cadena de caracteres y nos indica si es palindromo o no, los palindromos son frases que leidas de manera normal o alreves dicen exactamente lo mismo")
    println("5. En este programa te pide que ingreses los tres lados de cualquier tipo y te indica de que tipo es")
    println("6. Mediante un a funcion calcula el factorial del numero que ingreso")
    println("7. En el siguiente programa te pide que llenes un arreglo con palabras y te kas ordena de manera que las cadenas mas grandes van a lo ultimo")
    println("8. El ultimo programa te permite contar cuantas vocales tiene la cadena ingresada y te dice cuantas vocales tiene")
    println("  ")
    println("Que programa desea ejecutar: ")

    var valor = readLine()?.toIntOrNull()
    when(valor){
        1 -> primer_ejercicio()
        2 -> segundo_ejercicio()
        3 -> tercer_ejercicio()
        4 -> cuarto_ejercicio()
        5 -> quinto_ejercicio()
        6 -> sexto_ejercicio()
        7 -> septimo_ejercicio()
        8 -> octavo_ejercicio()
    }
}

fun primer_ejercicio(){
    val arreglo = IntArray(10)

    for (i in 0 until 10) {
        print("Ingrese un numero entero: ")
        arreglo[i] = readln().toInt()
    }

    for (i in 0 until 10) {
        arreglo[i] = arreglo[i] * arreglo[i]
    }

    println("Resultado del arreglo en donde cada elemento se elevo al cuadrado: ${arreglo.contentToString()}")
}

fun segundo_ejercicio(){
    println("Porfavor ingrese un numero entre el 1 y el 99999")
    var num = readln()?.toInt()

    if (num == null || num < 1 || num > 9999)
    {
        println("El numero que ingreso no es valiado dentro del rango")
    }
    else{
        val millar = num / 1000
        val centenas = num / 100
        val decenas = num /10
        val unidad = num / 1

        println("Dentro del numero $num que usted ingreso se encuentran")
        println("$millar millares")
        println("$centenas centenas")
        println("$decenas decenas")
        println("$unidad unidades")
    }
}

fun tercer_ejercicio(){
    val numDec = Scanner(System.`in`)

    print("Introduzca un número decimal: ")
    val decimal = numDec.nextInt()

    val binario = Integer.toBinaryString(decimal)
    val octal = Integer.toOctalString(decimal)
    val hexadecimal = Integer.toHexString(decimal)
    println("El número $decimal en binario es: $binario")
    println("El número $decimal en octal es: $octal")
    println("El número $decimal en hexadecimal es: $hexadecimal")
}

fun cuarto_ejercicio(){
    println("Ingrese una frase y revisaremos si es un palindromo: ")
    val cadenaCar = readln()!!.toLowerCase()
    
    val cadenaLimpia = cadenaCar.replace("\\s+".toRegex(), "").replace("\\p{Punct}+".toRegex(), "")

    val esPalindromo = cadenaLimpia == cadenaLimpia.reversed()

    if (esPalindromo) {
        println("$cadenaCar es un palíndromo")
    } else {
        println("$cadenaCar no es un palíndromo")
    }
    return
}

fun quinto_ejercicio(){
    var lado1: Int = 0
    var lado2: Int = 0
    var lado3: Int = 0

    println("Ingresa los 3 lados de un triangulo y determinare de tipo se trata")

    print("Primer lado: ")
    lado1 = readln()?.toInt()!!

    print("Segundo lado: ")
    lado2 = readln()?.toInt()!!

    print("Tercer lado: ")
    lado3 = readln()?.toInt()!!

    if (lado1 == 0 || lado2 == 0 || lado3 == 0){
        println("Ingreso valores incorrectos")
        return
    }
    else{
        if (lado1 == lado2 && lado2 == lado3){
            println("Usted ingreso los datos de un triangulo EQUILATERO")
        }
        else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3)
        {
            println("Usted ingreso los datos de un triangulo ISOSCELES")
        }
        else
        {
            println("Usted ingreso los datos de un triangulo ESCALENO")
        }
    }
    return
}

fun sexto_ejercicio(){
    var num: Int = 0
    println("Ingrese un numero y calculare su factorial: ")
    num = readln()?.toInt()!!

    val fatcorial = calculaFact(num)

    println("El factorial del numero $num es $fatcorial")
}

fun septimo_ejercicio(){
    val cadenas = mutableListOf<String>()
    for (i in 1..5) {
        print("Introduce una cadena de caracteres: ")
        cadenas.add(readLine()!!)
    }
    cadenas.sortBy {
        it.length
    }
    cadenas.forEach {
        println(it)
    }
}

fun octavo_ejercicio(){
    print("Introduce una cadena de caracteres: ")
    val cadena = readLine()!!

    val vocales = mutableMapOf('a' to 0, 'e' to 0, 'i' to 0, 'o' to 0, 'u' to 0)
    var total_vocal = 0

    for (char in cadena.toLowerCase()) {
        if (char in vocales.keys) {
            vocales[char] = vocales[char]!! + 1
            total_vocal++
        }
    }

    println("La cadena ingresada tiene un total de $total_vocal vocales")
    vocales.forEach {
            (key, value) -> println("Cantidad de '$key': $value")
    }
}

//FUNCIONES

fun calculaFact(num: Int): Int {
    if (num == 0){
        1
    }
    else{
        num * calculaFact(num - 1)
    }
    return 0
}