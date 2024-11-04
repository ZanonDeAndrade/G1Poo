import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarroEletrico {
    protected String id;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double bateria; // Capacidade total da bateria
    protected double autonomiaAtual;
    protected double porcentagemBateriaAtual;
    protected String categoria;
    protected List<Recarga> historicoRecargas; // Lista para armazenar o histórico de recargas

    public CarroEletrico(String id, String marca, String modelo, int ano, double bateria, double autonomiaTotal, double porcentagemBateriaAtual, String categoria) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.bateria = bateria;
        this.porcentagemBateriaAtual = porcentagemBateriaAtual;
        this.autonomiaAtual = autonomiaTotal * (porcentagemBateriaAtual / 100.0);
        this.categoria = categoria;
        this.historicoRecargas = new ArrayList<>(); // Inicializa a lista de recargas
    }

    // Método para carregar a bateria (renomeado)
    public void carregarBateria(double quantidadeEnergia, String eletroposto) {
        // Calcula a nova porcentagem da bateria
        double novaPorcentagem = porcentagemBateriaAtual + (quantidadeEnergia / bateria) * 100;

        // Verifica se a nova porcentagem não excede 100%
        if (novaPorcentagem > 100) {
            novaPorcentagem = 100;
        }

        // Atualiza a porcentagem da bateria
        setPorcentagemBateriaAtual(novaPorcentagem);

        // Adiciona a recarga ao histórico
        historicoRecargas.add(new Recarga(new Date(), eletroposto, quantidadeEnergia));

        System.out.println("Recarga registrada com sucesso!");
    }

    // Método para atualizar a autonomia atual com base na porcentagem da bateria
    private void atualizarAutonomia() {
        this.autonomiaAtual = this.bateria * (this.porcentagemBateriaAtual / 100.0);
    }

    public List<Recarga> getHistoricoRecargas() {
        return historicoRecargas;
    }

    public double getAutonomiaAtual() {
        return autonomiaAtual;
    }

    public void setAutonomiaAtual(double autonomiaAtual) {
        this.autonomiaAtual = autonomiaAtual;
    }

    // Getters e Setters existentes...

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

    public double getPorcentagemBateriaAtual() {
        return porcentagemBateriaAtual;
    }

    public void setPorcentagemBateriaAtual(double porcentagemBateriaAtual) {
        this.porcentagemBateriaAtual = porcentagemBateriaAtual;
        atualizarAutonomia(); // Atualiza a autonomia ao alterar a porcentagem da bateria
    }

    public String getCategoria() {
        return categoria;
    }
}
