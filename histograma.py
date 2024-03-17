#HISTOGRAMA - IVAN SAEZ
CARES_DAU: int = 6

llista_tiradas: List[int] = [0] * (CARES_DAU * 2 - 1)

def generar_histograma() -> None:
    _generar_tiradas()
    _mostrar_histograma()
    _mostrar_maximo()


def _generar_tiradas() -> None:
    for i in range(1, CARES_DAU + 1):
        for j in range(1, CARES_DAU + 1):
            llista_tiradas[i + j - 2] += 1


def _mostrar_histograma() -> None:
    for i, num_tiradas in enumerate(llista_tiradas):
        valor_tirada = _calcular_valor_tirada(i)
        print(f"{valor_tirada}:", "*" * num_tiradas)


def _calcular_valor_tirada(i: int) -> str:
    valor = i + 2
    return f"{valor:2}" if valor >= 10 else f" {valor}"


def _mostrar_maximo() -> None:
    valor_tirada = _calcular_valor_tirada_mes_repeticions()
    print(f"El maxim es {valor_tirada}.")


def _calcular_valor_tirada_mes_repeticions() -> int:
    index_maxim_tiradas = max(range(len(llista_tiradas)), key=lambda i: llista_tiradas[i])
    return index_maxim_tiradas + 2

generar_histograma()