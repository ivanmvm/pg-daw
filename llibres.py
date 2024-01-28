llibres = []
while True:
    print("Menú de la llibreria")
    print("1. Afegir llibre")
    print("2. Mostrar llista de llibres")
    print("3. Eliminar llibre")
    print("4. Sortir")
    opcio = int(input("Escull una opció: "))

    if opcio == 1:
        # Afegir llibre
        nom = input("Introdueix el nom del llibre: ")
        llibres.append(nom)
    
    elif opcio == 2:
        # Mostrar llista
        print(llibres)
    
    elif opcio == 3: 
        # Eliminar llibre
        if llibres:
            nom_eliminar = input("Introdueix el nom del llibre a eliminar: ")
            if nom_eliminar in llibres:
                llibres.remove(nom_eliminar)
            else:
                print("El llibre no es troba a la llibreria.")
        else:
            print("No hi ha llibres per eliminar")
        
    elif opcio == 4:
        # Sortir del bucle
        break
    
    else:
        print("Opció incorrecta!")

print("Fi del programa")
