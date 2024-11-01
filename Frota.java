public class Frota {
    public static void main(String[] args) {
        CarroCompacto compacto = new CarroCompacto("C001", "Nissan", "Leaf", 2022, 40);
        CarroSedan sedan = new CarroSedan("S001", "Tesla", "Model S", 2023, 100);
        CarroSuv suv = new CarroSuv("SUV001", "Audi", "e-tron", 2023, 95);

        // Exibindo informações diretamente dos atributos protegidos
        System.out.println("Carro Compacto - ID: " + compacto.id + ", Marca: " + compacto.marca + ", Autonomia Atual: " + compacto.autonomiaAtual + " km");
        System.out.println("Carro Sedan - ID: " + sedan.id + ", Marca: " + sedan.marca + ", Autonomia Atual: " + sedan.autonomiaAtual + " km");
        System.out.println("SUV Elétrico - ID: " + suv.id + ", Marca: " + suv.marca + ", Autonomia Atual: " + suv.autonomiaAtual + " km");
    }
}
