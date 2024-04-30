public class CompteBancaria {
    private String numeroCompte;
    private double saldo;

    public CompteBancaria(String numeroCompte, double saldoInicial) {
        this.numeroCompte = numeroCompte;
        this.saldo = saldoInicial;
    }

    public void ingressar(double quantitat) {
        if (quantitat > 0) {
            saldo += quantitat;
        }
    }

    public void retirar(double quantitat) {
        if (quantitat > 0 && saldo >= quantitat) {
            saldo -= quantitat;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }
}
