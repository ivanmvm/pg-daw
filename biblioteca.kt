class Libro(val titulo: String, val autor: String, var numExemplaresDisponibles: Int) {
    fun obtenerInformacion() {
        println("Título: $titulo")
        println("Autor: $autor")
        println("Número de ejemplares disponibles: $numExemplaresDisponibles")
    }
}

class Socio(val nombre: String, val apellido: String, val numeroSocio: Int) {
    fun solicitarPrestamo(prestamo: Prestamo) {
        println("El socio $nombre $apellido solicita un préstamo de libro")
    }

    fun devolverPrestamo(prestamo: Prestamo) {
        println("El socio $nombre $apellido devuelve un préstamo de libro")
    }

    fun mostrarInformacion() {
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("Número de socio: $numeroSocio")
    }
}

class Prestamo(val libro: Libro, val socio: Socio, val fechaPrestamo: String) {
    fun registrarPrestamo() {
        println("Se ha realizado el préstamo del libro ${libro.titulo} al socio ${socio.nombre} ${socio.apellido}")
    }

    fun devolverPrestamo() {
        println("Se ha devuelto el préstamo del libro ${libro.titulo} al socio ${socio.nombre} ${socio.apellido}")
    }

    fun mostrarInformacion() {
        println("Libro: ${libro.titulo}")
        println("Socio: ${socio.nombre} ${socio.apellido}")
        println("Fecha de préstamo: $fechaPrestamo")
    }
}

fun main() {
    val libro1 = Libro("El Hobbit", "J.R.R. Tolkien", 10)
    val libro2 = Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 5)

    val socio1 = Socio("Joel", "Jara", 1)
    val socio2 = Socio("Alvaro", "Fernandez", 2)

    val prestamo1 = Prestamo(libro1, socio1, "10-03-2024")
    val prestamo2 = Prestamo(libro2, socio2, "3-02-2024")

    prestamo1.registrarPrestamo()
    prestamo2.registrarPrestamo()

    socio1.solicitarPrestamo(prestamo1)
    socio2.solicitarPrestamo(prestamo2)

    socio1.devolverPrestamo(prestamo1)
    socio2.devolverPrestamo(prestamo2)

    prestamo1.devolverPrestamo()
    prestamo2.devolverPrestamo()

    socio1.mostrarInformacion()
    socio2.mostrarInformacion()

    libro1.obtenerInformacion()
    libro2.obtenerInformacion()

    prestamo1.mostrarInformacion()
    prestamo2.mostrarInformacion()
}