# FRASES CON MAS A - IVAN SAEZ
frase_actual = ""
frase_mes_as = ""
max_as = 0
fi = False

def main():
  while not fi:
    procesar_frase()
    mostrar_resultados()
  print("(El programa finaliza)")

def procesar_frase():
  global frase_actual, fi
  frase_actual = input("Escribe una frase:\n> ")
  if frase_actual == "fi":
    fi = True
  else:
    comparar_as()

def mostrar_resultados():
  print(f"La frase con más 'a's es: \"{frase_mes_as}\"")
  print(f"Tiene {max_as} 'a's.")

def comparar_as():
  global frase_mes_as, max_as
  num_as = frase_actual.lower().count("a")
  if num_as > max_as:
    max_as = num_as
    frase_mes_as = frase_actual

main()