import java.time.LocalDateTime;

public class Recarga {
    private LocalDateTime dataHora;
    private double bateriaAntes;
    private double bateriaDepois;

    public Recarga(LocalDateTime dataHora, double bateriaAntes, double bateriaDepois) {
        this.dataHora = dataHora;
        this.bateriaAntes = bateriaAntes;
        this.bateriaDepois = bateriaDepois;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getBateriaAntes() {
        return bateriaAntes;
    }

    public double getBateriaDepois() {
        return bateriaDepois;
    }

    @Override
    public String toString() {
        return "Data: " + dataHora + ", Bateria antes: " + bateriaAntes + "%, Bateria depois: " + bateriaDepois + "%";
    }
}
