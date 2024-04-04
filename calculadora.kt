fun solicitarOperacion(): String {
    println("Selecciona la operación (+, -, *, /):")
    return readLine().orEmpty()
}

fun solicitarNumero(mensaje: String): Int {
    println(mensaje)
    return readLine()?.toIntOrNull() ?: solicitarNumero("Entrada inválida. Por favor, introduce un número:")
}

fun calcularSuma(a: Int, b: Int): Int = a + b

fun calcularResta(a: Int, b: Int): Int = a - b

fun calcularMultiplicacion(a: Int, b: Int): Int = a * b

fun calcularDivision(a: Int, b: Int): Int {
    if (b == 0) {
        println("Error: División por cero no permitida.")
        return 0
    }
    return a / b
}

fun ejecutarOperacion(operacion: String, a: Int, b: Int): Int {
    println("Ejecutando operación...")
    return when (operacion) {
        "+" -> calcularSuma(a, b)
        "-" -> calcularResta(a, b)
        "*" -> calcularMultiplicacion(a, b)
        "/" -> calcularDivision(a, b)
        else -> {
            println("Operación no reconocida.")
            0
        }
    }
}

fun main() {
    val operacion = solicitarOperacion()
    val primerNumero = solicitarNumero("Introduce el primer número:")
    val segundoNumero = solicitarNumero("Introduce el segundo número:")

    val resultado = ejecutarOperacion(operacion, primerNumero, segundoNumero)
    println("El resultado es: $resultado")
}