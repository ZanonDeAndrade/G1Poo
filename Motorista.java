public class Motorista {
    private String nome;
    private String id;
    private String CNH;
    private String nivelExperiencia; // iniciante, intermediário, avançado

    public Motorista(String nome, String id, String CNH, String nivelExperiencia) {
        this.nome = nome;
        this.id = id;
        this.CNH = CNH;
        this.nivelExperiencia = nivelExperiencia;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getCNH() {
        return CNH;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }
}
