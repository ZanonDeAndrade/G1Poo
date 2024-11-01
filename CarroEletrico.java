public class CarroEletrico {
    protected String id;
    protected String marca;
    protected String modelo;
    protected int anoFabrica;
    protected double Bateria;
    protected double autonomiaMaxima;
    protected double autonomiaAtual;

    public CarroEletrico(String id, String marca, String modelo, int anoFabrica, double Bateria, double autonomiaMaxima) {

        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabrica = anoFabrica;
        this.Bateria = Bateria;
        this.autonomiaMaxima = autonomiaMaxima;
        this.autonomiaAtual = autonomiaMaxima;
    }

    public String getId() {
        return id;
    }

    public double getAutonomiaAtual() {
        return autonomiaAtual;
    }

    public void recarregar(double energia) {
        this.autonomiaAtual = Math.min(this.autonomiaAtual + energia, Bateria);
    }

    public void realizarViagem(double distancia) {
        if (distancia <= autonomiaAtual) {
            autonomiaAtual -= distancia;
        } else {
            throw new IllegalArgumentException("Autonomia insuficiente para a viagem.");
        }
    }
}