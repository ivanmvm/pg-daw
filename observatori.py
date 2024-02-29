from datetime import datetime

class ObservatoriTemperatures:
    def __init__(self):
        self.temperatures_enregistrades = {}

    def menu_principal(self):
        while True:
            self.mostrar_menu()
            opcio = self.llegir_opcio()
            self.executar_opcio(opcio)

    def mostrar_menu(self):
        print("Benvingut al registre de temperatures ")
        print("------------------------------------- ")
        print("[RT] Registrar temperatures setmanals.")
        print("[MJ] Consultar temperatura mitjana.")
        print("[DF] Consultar diferència màxima.")
        print("[FI] Sortir.")

    def llegir_opcio(self):
        opcio = input("Opció: ").upper()
        self.validar_opcio(opcio)
        return opcio

    def validar_opcio(self, opcio):
        if opcio not in ["RT", "MJ", "DF", "FI"]:
            print("Opció no vàlida. Torna a introduir.")

    def executar_opcio(self, opcio):
        if opcio == "RT":
            self.registrar_temperatures()
        elif opcio == "MJ":
            self.consultar_temperatura_mitjana()
        elif opcio == "DF":
            self.consultar_diferencia_maxima()
        elif opcio == "FI":
            self.sortir()

    def registrar_temperatures(self):
        print("Escriu les temperatures d'aquesta setmana:")
        temperatures = self.llegir_temperatures()
        data_actual = datetime.now().strftime("%Y-%m-%d")
        self.actualitzar_base_dades(data_actual, temperatures)

    def llegir_temperatures(self):
        try:
            temperatures = [float(temp) for temp in input().split()]
            return temperatures
        except ValueError:
            print("Error: Les temperatures han de ser nombres decimals.")
            return []

    def actualitzar_base_dades(self, data_actual, temperatures):
        self.temperatures_enregistrades[data_actual] = temperatures

    def consultar_temperatura_mitjana(self):
        if self.hi_ha_temperatures_enregistrades():
            data_actual = datetime.now().strftime("%Y-%m-%d")
            mitjana = self.calcular_temperatura_mitjana(data_actual)
            self.mostrar_resultats("temperatura mitjana", mitjana)
        else:
            print("No hi ha temperatures registrades.")

    def hi_ha_temperatures_enregistrades(self):
        return bool(self.temperatures_enregistrades)

    def calcular_temperatura_mitjana(self, data_actual):
        temperatures_setmana = self.temperatures_enregistrades.get(data_actual, [])
        if temperatures_setmana:
            mitjana = sum(temperatures_setmana) / len(temperatures_setmana)
            return round(mitjana, 2)
        else:
            return None

    def consultar_diferencia_maxima(self):
        if self.hi_ha_temperatures_enregistrades():
            data_actual = datetime.now().strftime("%Y-%m-%d")
            diferencia_maxima = self.calcular_diferencia_maxima(data_actual)
            self.mostrar_resultats("diferència màxima", diferencia_maxima)
        else:
            print("No hi ha temperatures registrades.")

    def calcular_diferencia_maxima(self, data_actual):
        temperatures_setmana = self.temperatures_enregistrades.get(data_actual, [])
        if temperatures_setmana:
            max_temperatura = max(temperatures_setmana)
            min_temperatura = min(temperatures_setmana)
            diferencia_maxima = max_temperatura - min_temperatura
            return round(diferencia_maxima, 2)
        else:
            return None

    def mostrar_resultats(self, tipus, valor):
        data_actual = datetime.now().strftime("%Y-%m-%d")
        print(f"Fins avui {data_actual} la {tipus} ha estat de {valor} graus.")

    def sortir(self):
        print("Fins aviat!")
        exit()

observatori = ObservatoriTemperatures()
observatori.menu_principal()
