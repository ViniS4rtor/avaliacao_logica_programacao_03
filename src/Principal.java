import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Reserva> agenda = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== AGENDA DIGITAL ===");

        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluirReserva();
                    break;
                case 2:
                    alterarReserva();
                    break;
                case 3:
                    excluirReserva();
                    break;
                case 4:
                    consultarReserva();
                    break;
                case 5:
                    listarReservas();
                    break;
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Exibe o menu
    private static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Incluir reserva");
        System.out.println("2 - Alterar reserva");
        System.out.println("3 - Excluir reserva");
        System.out.println("4 - Consultar reserva");
        System.out.println("5 - Listar reservas");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    // 1. Incluir nova reserva
    private static void incluirReserva() {
        System.out.println("\n--- INCLUIR RESERVA ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Data (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        System.out.print("Hora (hh:mm): ");
        String hora = scanner.nextLine();

        Reserva reserva = new Reserva(nome, data, hora);
        agenda.add(reserva);

        System.out.println("Reserva incluída com sucesso!");
    }

    // 2. Alterar reserva existente
    private static void alterarReserva() {
        System.out.println("\n--- ALTERAR RESERVA ---");

        if (agenda.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        listarComNumeros();

        System.out.print("Número da reserva: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < agenda.size()) {
            Reserva reserva = agenda.get(indice);

            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();

            System.out.print("Nova data: ");
            String data = scanner.nextLine();

            System.out.print("Nova hora: ");
            String hora = scanner.nextLine();

            reserva.setNome(nome);
            reserva.setData(data);
            reserva.setHora(hora);

            System.out.println("Reserva alterada com sucesso!");
        } else {
            System.out.println("Número inválido!");
        }
    }

    // 3. Excluir reserva
    private static void excluirReserva() {
        System.out.println("\n--- EXCLUIR RESERVA ---");

        if (agenda.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        listarComNumeros();

        System.out.print("Número da reserva: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < agenda.size()) {
            agenda.remove(indice);
            System.out.println("Reserva excluída com sucesso!");
        } else {
            System.out.println("Número inválido!");
        }
    }

    // 4. Consultar reserva específica
    private static void consultarReserva() {
        System.out.println("\n--- CONSULTAR RESERVA ---");

        if (agenda.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        System.out.print("Digite o nome para buscar: ");
        String busca = scanner.nextLine();

        barraDeProgresso();

        boolean encontrou = false;
        for (int i = 0; i < agenda.size(); i++) {
            Reserva reserva = agenda.get(i);
            if (reserva.getNome().toLowerCase().contains(busca.toLowerCase())) {
                System.out.println((i + 1) + ". " + reserva);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma reserva encontrada.");
        }
    }

    // 5. Listar todas as reservas
    private static void listarReservas() {
        System.out.println("\n--- TODAS AS RESERVAS ---");

        if (agenda.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
        } else {
            listarComNumeros();
        }
    }

    // Método auxiliar para listar com números
    private static void listarComNumeros() {
        for (int i = 0; i < agenda.size(); i++) {
            System.out.println((i + 1) + ". " + agenda.get(i));
        }
    }

    public static void barraDeProgresso() {
        for (int i = 0; i <= 100; i += 2) {
            int barras = i / 5; // 20 barras no total

            System.out.print("\r[");
            for (int j = 0; j < 20; j++) {
                if (j < barras) {
                    System.out.print("▓");
                } else {
                    System.out.print("░");
                }
            }
            System.out.printf("] %d%%", i);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.print("\r" + "".repeat(30));
    }
}