import java.util.HashMap;
import java.util.ArrayList;

class GestorTasques
{
	HashMap<String, ArrayList<Tasca>> llistes;
	HashMap<Integer, Tasca> tasques;

	public GestorTasques() {
		llistes = new HashMap<String, ArrayList<Tasca>>();
		llistes.put("Baixa", new ArrayList<Tasca>());
		llistes.put("Mitjana", new ArrayList<Tasca>());
		llistes.put("Alta", new ArrayList<Tasca>());
		tasques = new HashMap<Integer, Tasca>();
	}

	public void afegirTasca(String nomTasca, String prioritat) {
		Tasca tasca = new Tasca(nomTasca);
		llistes.get(prioritat).add(tasca);
		tasques.put(tasca.getId(), tasca);
	}

	public void tascaFeta(int idTasca) {
		tasques.get(idTasca).feta();
	}

	public void eliminarTasca(int idTasca) {
		tasques.remove(idTasca);
	}

	public void mostrarTotesLesTasques() {
		tasques.forEach((clau, tasca) -> {
			System.out.println(tasca);
		});
	}

	public void mostrarTasquesPerPrioritat(String prioritat) {
		System.out.println("Tasques de prioritat: " + prioritat);
		for (Tasca tasca: llistes.get(prioritat)) {
			System.out.println(tasca);
		}
	}
}

class Tasca 
{
	private static int numInstancies = 0;
	private int id;
	private String nom;
	private boolean estaFeta;

	public Tasca(String nom) {
		this.nom = nom;
		this.estaFeta = false;
		this.id = ++numInstancies;
	}

	public void feta() {
		this.estaFeta = true;
	}

	public int getId() {
		return this.id;
	}

	public String getNom() {
		return this.nom;
	}

	public boolean estaFeta() {
		return this.estaFeta;
	}

	public String toString() {
		return "Id: " + Integer.toString(id) + ", Nom: " + nom + ", Està feta: " + Boolean.toString(estaFeta);
	}
}

class Principal
{
	public static void main(String[] args) {
		GestorTasques gestor = new GestorTasques();
		System.out.println("Afegir tasca");
		gestor.afegirTasca("Aprovar Programació", "Alta");
		System.out.println("Fem print de tot");
		gestor.mostrarTotesLesTasques();
		System.out.println("Fem print de prioritat");
		gestor.mostrarTasquesPerPrioritat("Alta");
		System.out.println("Fem que la tasca estigui feta");
		gestor.tascaFeta(1);
		System.out.println("Fem print de tot");
		gestor.mostrarTotesLesTasques();
		System.out.println("Eliminem la tasca");
		gestor.eliminarTasca(1);
		System.out.println("Fem print de tot");
		gestor.mostrarTotesLesTasques();
	}
}
