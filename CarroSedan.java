public class CarroSedan extends CarroEletrico {
    public CarroSedan(String id, String marca, String modelo, int anoFabrica, double bateria, double porcentagemBateriaAtual) {
        super(id, marca, modelo, anoFabrica, bateria, 400.0, porcentagemBateriaAtual, "Sedan"); // Passa todos os parâmetros
    }

    public double tempoCarga() {
        return 6.0; // horas
    }
}
