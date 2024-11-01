import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<CarroEletrico> frota;
    private List<Eletroposto> eletropostos;

    public Main() {
        frota = new ArrayList<>();
        eletropostos = new ArrayList<>();
    }

    public void adicionarCarro(CarroEletrico carro) {
        frota.add(carro);
    }

    public void adicionarEletroposto(Eletroposto eletroposto) {
        eletropostos.add(eletroposto);
    }

    public void exibirCarrosDisponiveis() {
        System.out.println("Carros Disponíveis:");
        for (CarroEletrico carro : frota) {
            System.out.println("ID: " + carro.getId() + ", Marca: " + carro.getMarca() + ", Modelo: " + carro.getModelo() +
                    ", Ano: " + carro.getAno() + ", Autonomia de: " + carro.getAutonomiaAtual() + " km, " +
                    "Capacidade: " + carro.getBateria() + " kWh, " );
        }
    }

    public void exibirEletropostos() {
        System.out.println("Eletropostos Disponíveis:");
        for (Eletroposto eletroposto : eletropostos) {
            System.out.println("ID: " + eletroposto.getId() + ", Local: " + eletroposto.getLocal() +
                    ", Vagas: " + eletroposto.getVagasDisponiveis() + ", Tempo Médio de Carga: " + eletroposto.getTempoMedioCarga() + " horas");
        }
    }

    public void exibirDistanciaEletropostos() {
        System.out.println("Distância até Eletropostos:");
        for (Eletroposto eletroposto : eletropostos) {
            double distancia = calcularDistancia(eletroposto); // Método fictício para calcular distância
            System.out.println("Eletroposto ID: " + eletroposto.getId() + ", Distância: " + distancia + " km");
        }
    }

    private double calcularDistancia(Eletroposto eletroposto) {
        // Implementar a lógica para calcular a distância real
        return 0; // Placeholder, substitua pela lógica real
    }

    public void adicionarCarroDoUsuario() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Informe o ID do carro: ");
            String id = scanner.nextLine();

            System.out.print("Informe a marca do carro: ");
            String marca = scanner.nextLine();

            System.out.print("Informe o modelo do carro: ");
            String modelo = scanner.nextLine();

            System.out.print("Informe o ano do carro: ");
            int ano = Integer.parseInt(scanner.nextLine()); // Converte a entrada para int

            System.out.print("Informe a capacidade da bateria em kWh: ");
            double bateria = Double.parseDouble(scanner.nextLine()); // Converte a entrada para double

            System.out.print("Informe a autonomia atual em km: ");
            double autonomiaAtual = Double.parseDouble(scanner.nextLine()); // Converte a entrada para double

            CarroEletrico carro = new CarroEletrico(id, marca, modelo, ano, bateria, autonomiaAtual);
            adicionarCarro(carro);
            System.out.println("Carro adicionado com sucesso!");

        } catch (NumberFormatException e) {
            System.out.println("Erro: entrada inválida. Por favor, insira um número válido.");
        }
    }

    public void adicionarEletropostoDoUsuario() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Informe o ID do eletroposto: ");
            String id = scanner.nextLine();

            System.out.print("Informe o local do eletroposto: ");
            String local = scanner.nextLine();

            System.out.print("Informe o número de vagas disponíveis: ");
            int vagas = Integer.parseInt(scanner.nextLine());

            System.out.print("Informe o tempo médio de carga em horas: ");
            double tempoCarga = Double.parseDouble(scanner.nextLine());

            Eletroposto eletroposto = new Eletroposto(id, local, vagas, tempoCarga);
            adicionarEletroposto(eletroposto);
            System.out.println("Eletroposto adicionado com sucesso!");

        } catch (NumberFormatException e) {
            System.out.println("Erro: entrada inválida. Por favor, insira um número válido.");
        }
    }

    public void realizarViagem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID do carro que deseja utilizar: ");
        String idCarro = scanner.nextLine();

        CarroEletrico carro = null;
        for (CarroEletrico c : frota) {
            if (c.getId().equals(idCarro)) {
                carro = c;
                break;
            }
        }

        if (carro == null) {
            System.out.println("Carro não encontrado.");
            return;
        }

        System.out.print("Informe a distância da viagem em km: ");
        try {
            double distancia = Double.parseDouble(scanner.nextLine());

            if (carro.getAutonomiaAtual() >= distancia) {
                carro.setAutonomiaAtual(carro.getAutonomiaAtual() - distancia);
                System.out.println("Viagem realizada com sucesso! Autonomia atual do carro: " + carro.getAutonomiaAtual() + " km.");
            } else {
                System.out.println("Erro: Autonomia insuficiente para realizar a viagem.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: entrada inválida. Por favor, insira uma distância válida.");
        }
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Ver Carros Disponíveis");
            System.out.println("2. Ver Eletropostos");
            System.out.println("3. Ver Distância dos Eletropostos");
            System.out.println("4. Adicionar Carro");
            System.out.println("5. Adicionar Eletroposto");
            System.out.println("6. Realizar Viagem");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    sistema.exibirCarrosDisponiveis();
                    break;
                case 2:
                    sistema.exibirEletropostos();
                    break;
                case 3:
                    sistema.exibirDistanciaEletropostos();
                    break;
                case 4:
                    sistema.adicionarCarroDoUsuario();
                    break;
                case 5:
                    sistema.adicionarEletropostoDoUsuario();
                    break;
                case 6:
                    sistema.realizarViagem();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
