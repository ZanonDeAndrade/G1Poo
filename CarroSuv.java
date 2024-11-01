public class CarroSuv extends CarroEletrico {
    public CarroSuv(String id, String marca, String modelo, int anoFabrica, double Bateria) {
        super(id, marca, modelo, anoFabrica, Bateria, 500); // Exemplo de autonomia para SUV
    }


    public double tempoCarga() {
        return 8.0; // horas
    }
}
