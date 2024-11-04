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




    public String toString() {
        return "Eletroposto ID: " + id + 
               ", Localização: " + local + 
               ", Vagas Disponíveis: " + vagasDisponiveis + 
               ", Tempo Médio de Carga: " + tempoMedioCarga + " horas";
    }
}
