import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private Map<String, Llibre> llibres;

    public Biblioteca() {
        this.llibres = new HashMap<>();
    }

    public void afegirLlibre(Llibre llibre) {
        llibres.put(llibre.getTitol(), llibre);
    }

    public void prestarLlibre(String titol) {
        Llibre llibre = llibres.get(titol);
        if (llibre != null && llibre.getEstat().equals("disponible")) {
            llibre.setEstat("prestat");
        }
    }

    public void retornarLlibre(String titol) {
        Llibre llibre = llibres.get(titol);
        if (llibre != null && llibre.getEstat().equals("prestat")) {
            llibre.setEstat("disponible");
        }
    }

    public Llibre getLlibre(String titol) {
        return llibres.get(titol);
    }
}

class Llibre {
    private String titol;
    private String autor;
    private String estat;

    public Llibre(String titol, String autor) {
        this.titol = titol;
        this.autor = autor;
        this.estat = "disponible";
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
}
