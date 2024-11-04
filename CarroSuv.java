public class CarroSuv extends CarroEletrico {
    public CarroSuv(String id, String marca, String modelo, int anoFabrica, double bateria, double porcentagemBateriaAtual) {
        super(id, marca, modelo, anoFabrica, bateria, 500.0, porcentagemBateriaAtual, "SUV"); // Passa todos os parâmetros, incluindo a categoria
    }

    public double tempoCarga() {
        return 8.0; // horas
    }
}
