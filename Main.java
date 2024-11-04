import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<CarroEletrico> frota;
    private List<Eletroposto> eletropostos;
    private List<Motorista> motoristas;

    public Main() {
        frota = new ArrayList<>();
        eletropostos = new ArrayList<>();
        motoristas = new ArrayList<>();
    }

    public void adicionarCarro(CarroEletrico carro) {
        frota.add(carro);
        System.out.println("Carro adicionado com sucesso!");
    }

    public void removerCarro(String id) {
        CarroEletrico carroParaRemover = null;
        for (CarroEletrico carro : frota) {
            if (carro.getId().equals(id)) {
                carroParaRemover = carro;
                break;
            }
        }

        if (carroParaRemover != null) {
            frota.remove(carroParaRemover);
            System.out.println("Carro removido com sucesso!");
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    public void exibirCarrosDisponiveis() {
        System.out.println("Carros Disponíveis:");
        for (CarroEletrico carro : frota) {
            System.out.println("ID: " + carro.getId() + ", Marca: " + carro.getMarca() + ", Modelo: " + carro.getModelo() +
                    ", Ano: " + carro.getAno() + ", Autonomia de: " + carro.getAutonomiaAtual() + " km, " +
                    "Capacidade: " + carro.getBateria() + " kWh, " +
                    "Categoria: " + carro.getCategoria() + 
                    ", Bateria Atual: " + carro.getPorcentagemBateriaAtual() + "%");
        }
    }

    public void realizarViagem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a categoria do carro para a viagem:");
        System.out.println("1. Compacto");
        System.out.println("2. SUV");
        System.out.println("3. Sedan");
        System.out.print("Informe a categoria desejada: ");
        int categoriaEscolhida = Integer.parseInt(scanner.nextLine());

        String categoria;
        switch (categoriaEscolhida) {
            case 1:
                categoria = "Compacto";
                break;
            case 2:
                categoria = "SUV";
                break;
            case 3:
                categoria = "Sedan";
                break;
            default:
                System.out.println("Opção inválida! Voltando ao menu principal.");
                return;        
        }

        List<CarroEletrico> carrosDisponiveis = new ArrayList<>();
        for (CarroEletrico carro : frota) {
            if (carro.getCategoria().equalsIgnoreCase(categoria)) {
                carrosDisponiveis.add(carro);
            }
        }

        if (carrosDisponiveis.isEmpty()) {
            System.out.println("Não há carros disponíveis nesta categoria.");
            return;
        }

        System.out.println("Carros disponíveis na categoria " + categoria + ":");
        for (int i = 0; i < carrosDisponiveis.size(); i++) {
            CarroEletrico carro = carrosDisponiveis.get(i);
            System.out.println((i + 1) + ". ID: " + carro.getId() + ", Marca: " + carro.getMarca() +
                    ", Modelo: " + carro.getModelo() + ", Bateria: " + carro.getBateria() +
                    " kWh, Autonomia: " + carro.getAutonomiaAtual() + " km" + "Bateria Atual: " + carro.getPorcentagemBateriaAtual());
        }

        System.out.print("Escolha o carro desejado (número): ");
        int carroEscolhido = Integer.parseInt(scanner.nextLine()) - 1;
        if (carroEscolhido < 0 || carroEscolhido >= carrosDisponiveis.size()) {
            System.out.println("Carro escolhido inválido.");
            return;
        }
        CarroEletrico carroParaViagem = carrosDisponiveis.get(carroEscolhido);

        if (motoristas.isEmpty()) {
            System.out.println("Não há motoristas disponíveis.");
            return;
        }

        System.out.println("Motoristas disponíveis:");
        for (int i = 0; i < motoristas.size(); i++) {
            Motorista motorista = motoristas.get(i);
            System.out.println((i + 1) + ". Nome: " + motorista.getNome() + ", CNH: " + motorista.getCnh());
        }

        System.out.print("Escolha o motorista desejado (número): ");
        int motoristaEscolhido = Integer.parseInt(scanner.nextLine()) - 1;
        if (motoristaEscolhido < 0 || motoristaEscolhido >= motoristas.size()) {
            System.out.println("Motorista escolhido inválido.");
            return;
        }
        Motorista motoristaParaViagem = motoristas.get(motoristaEscolhido);

        System.out.println("Viagem iniciada com o carro " + carroParaViagem.getModelo() +
                " e o motorista " + motoristaParaViagem.getNome() + ".");
    }

    public void adicionarCarroDoUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o ID do carro: ");
        String id = scanner.nextLine();
        System.out.print("Informe a marca do carro: ");
        String marca = scanner.nextLine();
        System.out.print("Informe o modelo do carro: ");
        String modelo = scanner.nextLine();
        System.out.print("Informe o ano do carro: ");
        int ano = Integer.parseInt(scanner.nextLine());
        System.out.print("Informe a capacidade da bateria (em kWh): ");
        double bateria = Double.parseDouble(scanner.nextLine());
        System.out.print("Informe a autonomia total do carro (em km): ");
        double autonomiaTotal = Double.parseDouble(scanner.nextLine());
        System.out.print("Informe a porcentagem da bateria atual (em %): ");
        double porcentagemBateriaAtual = Double.parseDouble(scanner.nextLine());
        System.out.print("Informe a categoria do carro (Compacto, SUV, Sedan): ");
        String categoria = scanner.nextLine();
    
        CarroEletrico carro = new CarroEletrico(id, marca, modelo, ano, bateria, autonomiaTotal, porcentagemBateriaAtual, categoria);
        adicionarCarro(carro);
    }

    public void exibirEletropostos() {
        if (eletropostos.isEmpty()) {
            System.out.println("Nenhum eletroposto cadastrado.");
        } else {
            System.out.println("Lista de Eletropostos:");
            for (Eletroposto eletroposto : eletropostos) {
                System.out.println(eletroposto);
            }
        }
    }

    public void adicionarEletropostoDoUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o ID do eletroposto: ");
        String id = scanner.nextLine();
        System.out.print("Informe a localização do eletroposto: ");
        String localizacao = scanner.nextLine();
        System.out.print("Informe o número de vagas disponíveis: ");
        int vagasDisponiveis = Integer.parseInt(scanner.nextLine());
        System.out.print("Informe o tempo médio de carga (em horas): ");
        double tempoMedioCarga = Double.parseDouble(scanner.nextLine());
    
        Eletroposto eletroposto = new Eletroposto(id, localizacao, vagasDisponiveis, tempoMedioCarga);
        eletropostos.add(eletroposto);
        System.out.println("Eletroposto adicionado com sucesso!");
    }

    public void carregarCarro() {
        Scanner scanner = new Scanner(System.in);
    
        if (frota.isEmpty()) {
            System.out.println("Não há carros disponíveis para carregar.");
            return;
        }
    
        System.out.println("Carros disponíveis para carregar:");
        for (int i = 0; i < frota.size(); i++) {
            CarroEletrico carro = frota.get(i);
            System.out.println((i + 1) + ". ID: " + carro.getId() + ", Marca: " + carro.getMarca() +
                    ", Modelo: " + carro.getModelo() + ", Bateria: " + carro.getBateria() +
                    " kWh, Autonomia: " + carro.getAutonomiaAtual() + " km");
        }
    
        System.out.print("Escolha o carro desejado (número): ");
        int carroEscolhido = Integer.parseInt(scanner.nextLine()) - 1;
        if (carroEscolhido < 0 || carroEscolhido >= frota.size()) {
            System.out.println("Carro escolhido inválido.");
            return;
        }
        CarroEletrico carroParaCarregar = frota.get(carroEscolhido);
    
        if (eletropostos.isEmpty()) {
            System.out.println("Não há eletropostos disponíveis para carregar.");
            return;
        }
    
        System.out.println("Eletropostos disponíveis:");
        for (int i = 0; i < eletropostos.size(); i++) {
            Eletroposto eletroposto = eletropostos.get(i);
            System.out.println((i + 1) + ". ID: " + eletroposto.getId() + ", Localização: " + eletroposto.getLocal() +
                    ", Vagas disponíveis: " + eletroposto.getVagasDisponiveis());
        }
    
        System.out.print("Escolha o eletroposto desejado (número): ");
        int eletropostoEscolhido = Integer.parseInt(scanner.nextLine()) - 1;
        if (eletropostoEscolhido < 0 || eletropostoEscolhido >= eletropostos.size()) {
            System.out.println("Eletroposto escolhido inválido.");
            return;
        }
        Eletroposto eletropostoParaCarregar = eletropostos.get(eletropostoEscolhido);
    
        System.out.println("Carro " + carroParaCarregar.getModelo() + " está sendo carregado no eletroposto " +
                eletropostoParaCarregar.getLocal());
    }

    // Método para cadastrar motorista
    public void cadastrarMotorista() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Informe o nome do motorista: ");
        String nome = scanner.nextLine();
    
        System.out.print("Informe o ID do motorista: ");
        String id = scanner.nextLine();
    
        System.out.print("Informe o número da CNH do motorista: ");
        String CNH = scanner.nextLine();
    
        System.out.print("Informe o nível de experiência (iniciante, intermediário, avançado): ");
        String nivelExperiencia = scanner.nextLine();
    
        Motorista motorista = new Motorista(nome, id, CNH, nivelExperiencia);
        motoristas.add(motorista); 
        System.out.println("Motorista cadastrado com sucesso!");
    }
    

    public void exibirMotoristas() {
        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista cadastrado.");
        } else {
            System.out.println("Lista de Motoristas:");
            for (Motorista motorista : motoristas) {
                System.out.println(motorista);
            }
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
    
        do {
            System.out.println("-------Sistema de Gestão de Frota de Carros Elétricos--------");
            System.out.println("1. Adicionar carro");
            System.out.println("2. Remover carro");
            System.out.println("3. Exibir carros disponíveis");
            System.out.println("4. Realizar viagem");
            System.out.println("5. Adicionar eletroposto");
            System.out.println("6. Exibir eletropostos");
            System.out.println("7. Carregar carro elétrico");
            System.out.println("8. Adicionar motorista");
            System.out.println("9. Exibir motoristas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());
    
            switch (opcao) {
                case 1:
                    adicionarCarroDoUsuario();
                    break;
                case 2:
                    System.out.print("Informe o ID do carro a ser removido: ");
                    String id = scanner.nextLine();
                    removerCarro(id);
                    break;
                case 3:
                    exibirCarrosDisponiveis();
                    break;
                case 4:
                    realizarViagem();
                    break;
                case 5:
                    adicionarEletropostoDoUsuario();
                    break;
                case 6:
                    exibirEletropostos();
                    break;
                case 7:
                    carregarCarro();
                    break;
                case 8:
                    cadastrarMotorista();
                    break;
                case 9:
                    exibirMotoristas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.menu();
    }
}
