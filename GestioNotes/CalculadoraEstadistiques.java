package prog.ivan;

class CalculadoraEstadistiques {
    public double calcularMitjana(double[] notes) {
        if (notes.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double nota : notes) {
            sum += nota;
        }
        return sum / notes.length;
    }

    public double calcularMaxim(double[] notes) {
        if (notes.length == 0) {
            return 0.0;
        }
        double max = notes[0];
        for (double nota : notes) {
            max = Math.max(max, nota);
        }
        return max;
    }

    public double calcularMinim(double[] notes) {
        if (notes.length == 0) {
            return 0.0;
        }
        double min = notes[0];
        for (double nota : notes) {
            min = Math.min(min, nota);
        }
        return min;
    }
}