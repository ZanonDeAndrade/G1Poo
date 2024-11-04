import java.util.Date;

public class Recarga {
    private Date data;
    private String eletroposto;
    private double quantidadeEnergia;

    public Recarga(Date data, String eletroposto, double quantidadeEnergia) {
        this.data = data;
        this.eletroposto = eletroposto;
        this.quantidadeEnergia = quantidadeEnergia;
    }

    // Getters
    public Date getData() {
        return data;
    }

    public String getEletroposto() {
        return eletroposto;
    }

    public double getQuantidadeEnergia() {
        return quantidadeEnergia;
    }
}
