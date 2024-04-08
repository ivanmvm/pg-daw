class Viatge(val id: Int, val destinacio: String, val preu: Double) {
    fun informacioResumida(): String = "ID: $id, Destinació: $destinacio, Preu: $preu"
}

class Client(val id: Int, val nom: String) {
    val reserves = mutableListOf<Reserva>()
}

class Reserva(val client: Client, val viatge: Viatge)

val viatges = mutableListOf<Viatge>()
val clients = mutableListOf<Client>()

fun afegirViatge(viatge: Viatge) {
    viatges.add(viatge)
}

fun obtenirInformacioViatges(): String = viatges.joinToString(separator = "\n") { it.informacioResumida() }

fun informacioDetalladaViatge(id: Int): String? = viatges.find { it.id == id }?.let { "Destinació: ${it.destinacio}, Preu: ${it.preu}" }

fun registrarClient(nom: String): Client {
    val client = Client(clients.size + 1, nom)
    clients.add(client)
    return client
}

fun ferReserva(clientId: Int, viatgeId: Int): Reserva? {
    val client = clients.find { it.id == clientId }
    val viatge = viatges.find { it.id == viatgeId }
    if (client != null && viatge != null) {
        val reserva = Reserva(client, viatge)
        client.reserves.add(reserva)
        return reserva
    }
    return null
}

fun informacioDetalladaReserva(clientId: Int): String? {
    val client = clients.find { it.id == clientId }
    return client?.reserves?.joinToString(separator = "\n") { "Client: ${it.client.nom}, Destinació: ${it.viatge.destinacio}, Preu: ${it.viatge.preu}" }
}

fun mostrarMenu() {
    println("Benvingut a l'Agència de Viatges")
    println("1. Afegir Viatge")
    println("2. Veure Viatges")
    println("3. Registrar Client")
    println("4. Fer Reserva")
    println("5. Sortir")
    println("Selecciona una opció:")
}

fun main() {
    var opcio: Int
    do {
        mostrarMenu()
        opcio = readLine()?.toInt() ?: 0
        when (opcio) {
            1 -> {
                println("Introdueix ID, destinació i preu del viatge (separats per coma):")
                val (id, destinacio, preu) = readLine()!!.split(",").map { it.trim() }
                afegirViatge(Viatge(id.toInt(), destinacio, preu.toDouble()))
                println("Viatge afegit amb èxit.")
            }
            2 -> println(obtenirInformacioViatges())
            3 -> {
                println("Introdueix el nom del client:")
                val nom = readLine()!!
                val client = registrarClient(nom)
                println("Client registrat amb ID: ${client.id}")
            }
            4 -> {
                println("Introdueix ID del client i ID del viatge (separats per coma):")
                val (clientId, viatgeId) = readLine()!!.split(",").map { it.trim() }
                val reserva = ferReserva(clientId.toInt(), viatgeId.toInt())
                if (reserva != null) {
                    println("Reserva realitzada amb èxit.")
                } else {
                    println("No s'ha pogut realitzar la reserva.")
                }
            }
        }
    } while (opcio != 5)
    println("Gràcies per utilitzar l'aplicació.")
}