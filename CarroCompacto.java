public class CarroCompacto extends CarroEletrico {
    public CarroCompacto(String id, String marca, String modelo, int anoFabrica, double bateria, double porcentagemBateriaAtual) {
        super(id, marca, modelo, anoFabrica, bateria, 200.0, porcentagemBateriaAtual, "Compacto"); // Passa todos os parâmetros, incluindo a categoria
    }

    public double tempoCarga() {
        return 4.0; // horas
    }
}
