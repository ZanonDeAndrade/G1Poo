public class CarroEletrico {
    protected String id;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double bateria;
    protected double autonomiaAtual;
    protected double porcentagemBateriaAtual;
    protected String categoria; 

    public CarroEletrico(String id, String marca, String modelo, int ano, double bateria, double autonomiaTotal, double porcentagemBateriaAtual, String categoria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.bateria = bateria;
        this.porcentagemBateriaAtual = porcentagemBateriaAtual;
        this.autonomiaAtual = autonomiaTotal * (porcentagemBateriaAtual / 100.0);
        this.categoria = categoria; 
    }

    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getBateria() {
        return bateria;
    }

    public double getAutonomiaAtual() {
        return autonomiaAtual;
    }

    public void setAutonomiaAtual(double autonomiaAtual) {
        this.autonomiaAtual = autonomiaAtual;
    }

    public double getPorcentagemBateriaAtual() {
        return porcentagemBateriaAtual;
    }

    public void setPorcentagemBateriaAtual(double porcentagemBateriaAtual) {
        this.porcentagemBateriaAtual = porcentagemBateriaAtual;
        this.autonomiaAtual = this.bateria * (porcentagemBateriaAtual / 100.0);
    }

    public String getCategoria() {
        return categoria;
    }
}
