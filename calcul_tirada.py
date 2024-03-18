# Inicialitzem una variable per emmagatzemar el valor de la tirada
valor_tirada = 0

# Definim una funció per generar una tirada aleatòria de dos daus
def generar_tirada():
    # Generem dos nombres aleatoris entre 1 i 6
    dau1 = random.randint(1, 6)
    dau2 = random.randint(1, 6)
    # Sumem els dos nombres per obtenir la tirada
    return dau1 + dau2

# Definim una funció per calcular la probabilitat de treure un valor concret
def calcular_probabilitat(valor):
    # Comprovem que el valor sigui entre 2 i 12
    if valor < 2 or valor > 12:
        print("El valor no és entre 2 i 12.")
        return

    # Generem una llista amb les tirades possibles
    tirades = []
    for i in range(2, 13):
        tirades.append(generar_tirada())

    # Comptem el nombre de tirades que valen menys o igual que el valor especificat
    comptador = 0
    for tirada in tirades:
        if tirada <= valor:
            comptador += 1

    # Calculem la probabilitat
    probabilitat = comptador / len(tirades) * 100

    # Mostrem el resultat
    print("La probabilitat de treure {} o menys és {:.2f}%.".format(valor, probabilitat))

# Llegim el valor a calcular pel teclat
valor = int(input("Escriu el valor a calcular [2 - 12]: "))

# Processam l'entrada
if valor >= 2 and valor <= 12:
    calcular_probabilitat(valor)
else:
    print("El valor no és entre 2 i 12.")