public class CarroCompacto extends CarroEletrico {
    public CarroCompacto(String id, String marca, String modelo, int anoFabrica, double bateria, double porcentagemBateriaAtual) {
        super(id, marca, modelo, anoFabrica, bateria, 200.0, porcentagemBateriaAtual, "Compacto"); //Passa os parametros
    }

    public double tempoCarga() {
        return 4.0; 
    }
}
