import java.util.ArrayList;

public class LlistaTasques {
    private ArrayList<Tasca> tasques;

    public LlistaTasques() {
        this.tasques = new ArrayList<>();
    }

    public void afegirTasca(Tasca tasca) {
        this.tasques.add(tasca);
    }

    public void completarTasca(int index) {
        if (index >= 0 && index < tasques.size()) {
            tasques.get(index).setEstat("completat");
        }
    }

    public ArrayList<Tasca> getTasques() {
        return tasques;
    }
}

class Tasca {
    private String descripcio;
    private String estat;

    public Tasca(String descripcio, String estat) {
        this.descripcio = descripcio;
        this.estat = estat;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
}
