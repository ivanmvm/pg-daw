package prog.ivan;

import java.util.HashMap;
import java.util.Map;

class GestorNotes {
    private Map<String, double[]> notesPerAlumne;

    public GestorNotes() {
        notesPerAlumne = new HashMap<>();
    }

    public void registrarNotes(String nomAlumne, double[] notes) {
        notesPerAlumne.put(nomAlumne, notes);
    }

    public double[] obtenirNotes(String nomAlumne) {
        return notesPerAlumne.getOrDefault(nomAlumne, new double[0]);
    }
}