import java.util.ArrayList;
import java.util.List;

public class ReservaVols {
    private List<Vol> vols;
    private List<ReservaVol> reserves;

    public ReservaVols() {
        this.vols = new ArrayList<>();
        this.reserves = new ArrayList<>();
    }

    public void afegirVol(Vol vol) {
        vols.add(vol);
    }

    public ReservaVol reservarVol(String codiVol, Passatger passatger) {
        for (Vol vol : vols) {
            if (vol.getCodiVol().equals(codiVol) && vol.hiHaPlacesDisponibles()) {
                ReservaVol reserva = new ReservaVol(passatger, vol);
                reserves.add(reserva);
                vol.reservarPlaça();
                return reserva;
            }
        }
        return null;
    }
}

class Vol {
    private String codiVol;
    private int placesDisponibles;

    public Vol(String codiVol, int placesDisponibles) {
        this.codiVol = codiVol;
        this.placesDisponibles = placesDisponibles;
    }

    public String getCodiVol() {
        return codiVol;
    }

    public boolean hiHaPlacesDisponibles() {
        return placesDisponibles > 0;
    }

    public void reservarPlaça() {
        if (hiHaPlacesDisponibles()) {
            placesDisponibles--;
        }
    }
}

class Passatger {
    private String nom;
    private String dni;

    public Passatger(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public String getDni() {
        return dni;
    }
}

class ReservaVol {
    private Passatger passatger;
    private Vol vol;

    public ReservaVol(Passatger passatger, Vol vol) {
        this.passatger = passatger;
        this.vol = vol;
    }

    public Passatger getPassatger() {
        return passatger;
    }

    public Vol getVol() {
        return vol;
    }
}
