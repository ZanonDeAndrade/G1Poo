public class Eletroposto {
    protected String id;
    protected String local;
    protected int vagasDisponiveis;
    protected double tempoMedioCarga;

    public Eletroposto(String id, String local, int vagasDisponiveis, double tempoMedioCarga) {
        this.id = id;
        this.local = local;
        this.vagasDisponiveis = vagasDisponiveis;
        this.tempoMedioCarga = tempoMedioCarga;
    }

    public String getId() {
        return id;
    }

    public String getLocal() {
        return local;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public double getTempoMedioCarga() {
        return tempoMedioCarga;
    }

    // Método para alocar uma vaga
    public boolean alocarVaga() {
        if (vagasDisponiveis > 0) {
            vagasDisponiveis--;
            return true; // Vaga alocada com sucesso
        }
        return false; // Sem vagas disponíveis
    }

    // Método para liberar uma vaga
    public void liberarVaga() {
        vagasDisponiveis++;
    }

    @Override
    public String toString() {
        return "Eletroposto ID: " + id + 
               ", Localização: " + local + 
               ", Vagas Disponíveis: " + vagasDisponiveis + 
               ", Tempo Médio de Carga: " + tempoMedioCarga + " horas";
    }
}
