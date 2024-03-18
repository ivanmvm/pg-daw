import random

def generate_secret_combination():
    """Genera una combinació secreta de 5 lletres aleatòries"""
    letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    secret_combination = []
    for i in range(5):
        letter = random.choice(letters)
        secret_combination.append(letter)
    return secret_combination

def get_hints(guess, secret_combination):
    """Retorna les pistes per a cada lletra de la combinació secreta"""
    hints = []
    for i in range(len(guess)):
        if guess[i] == secret_combination[i]:
            hints.append('O')
        elif guess[i] in secret_combination:
            hints.append('X')
        else:
            hints.append('.')
    return hints

def play_game():
    """Gestiona els intents de l'usuari i proporciona les pistes corresponents"""
    secret_combination = generate_secret_combination()
    while True:
        guess = input("Escriu 5 lletres minúscules: ")
        hints = get_hints(guess, secret_combination)
        print("La resposta és", hints)
        if guess == secret_combination:
            break
    print("Has encertat!")

play_game()