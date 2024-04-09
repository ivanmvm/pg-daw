class Coordenada:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def mover(self, dx=0, dy=0):
        self.x += dx
        self.y += dy

class Main:
    def __init__(self):
        coordenada = Coordenada()
        coordenada.mover(1, 0)
        print(f"Nueva coordenada después de mover a la derecha: ({coordenada.x}, {coordenada.y})")

        coordenada.mover(0, 1)
        print(f"Nueva coordenada después de mover arriba: ({coordenada.x}, {coordenada.y})")

Main()