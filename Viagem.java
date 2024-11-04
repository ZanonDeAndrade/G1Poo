import java.util.List;

public class Viagem {
    private Motorista motorista;
    private CarroEletrico carro;
    private double quilometragemPercorrida;
    private String destino;
    private List<Eletroposto> paradasParaRecarga;

    public Viagem(Motorista motorista, CarroEletrico carro, double quilometragemPercorrida, String destino) {
        this.motorista = motorista;
        this.carro = carro;
        this.quilometragemPercorrida = quilometragemPercorrida;
        this.destino = destino;
    }



    public Motorista getMotorista() {
        return motorista;
    }

    public CarroEletrico getCarro() {
        return carro;
    }

    public double getQuilometragemPercorrida() {
        return quilometragemPercorrida;
    }

    public String getDestino() {
        return destino;
    }

    public List<Eletroposto> getParadasParaRecarga() {
        return paradasParaRecarga;
    }


    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setCarro(CarroEletrico carro) {
        this.carro = carro;
    }

    public void setQuilometragemPercorrida(double quilometragemPercorrida) {
        this.quilometragemPercorrida = quilometragemPercorrida;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setParadasParaRecarga(List<Eletroposto> paradasParaRecarga) {
        this.paradasParaRecarga = paradasParaRecarga;
    }
}
