llibres = []
prestecs = []

while True:
    print("Menú de la llibreria")
    print("1. Afegir llibre")
    print("2. Mostrar llista de llibres")
    print("3. Eliminar llibre")
    print("4. Registrar préstec")
    print("5. Mostrar llista de llibres prestats")
    print("6. Gestionar devolució de llibres")
    print("7. Sortir")
    opcio = int(input("Escull una opció: "))

    if opcio == 1:
        # Afegir llibre
        nom = input("Introdueix el nom del llibre: ")
        llibres.append(nom)

    elif opcio == 2:
        # Mostrar llista
        print("Llista de llibres:")
        for llibre in llibres:
            print(llibre)

    elif opcio == 3:
        # Eliminar llibre
        if llibres:
            nom_eliminar = input("Introdueix el nom del llibre a eliminar: ")
            if nom_eliminar in llibres:
                llibres.remove(nom_eliminar)
                print("Llibre eliminat amb èxit.")
            else:
                print("El llibre no es troba a la llibreria.")
        else:
            print("No hi ha llibres per eliminar")

    elif opcio == 4:
        # Registrar préstec
        if llibres:
            nom_prestec = input("Introdueix el nom del llibre a prestar: ")
            if nom_prestec in llibres:
                prestecs.append(nom_prestec)
                llibres.remove(nom_prestec)
                print("Préstec registrat amb èxit.")
            else:
                print("El llibre no es troba a la llibreria.")
        else:
            print("No hi ha llibres disponibles per prestar.")

    elif opcio == 5:
        # Mostrar llista de llibres prestats
        print("Llista de llibres prestats:")
        for prestec in prestecs:
            print(prestec)

    elif opcio == 6:
        # Gestionar devolució de llibres
        if prestecs:
            nom_devolucio = input("Introdueix el nom del llibre a retornar: ")
            if nom_devolucio in prestecs:
                prestecs.remove(nom_devolucio)
                llibres.append(nom_devolucio)
                print("Devolució gestionada amb èxit.")
            else:
                print("El llibre no està prestat.")
        else:
            print("No hi ha llibres prestats.")

    elif opcio == 7:
        # Sortir del bucle
        break

    else:
        print("Opció incorrecta!")

print("Fi del programa")