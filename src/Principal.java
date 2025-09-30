
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    // ArrayList para armazenar as reservas
    private static ArrayList<Reserva> agenda = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE AGENDA DIGITAL ===");
        System.out.println("Bem-vindo ao sistema de gerenciamento de reservas!\n");

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();

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
                    listarTodasReservas();
                    break;
                case 0:
                    System.out.println("\nObrigado por usar o Sistema de Agenda Digital!");
                    System.out.println("Programa encerrado com sucesso.");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }

            if (opcao != 0) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }

    /**
     * Exibe o menu principal da aplicação
     */
    private static void exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              MENU PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1 - Incluir nova reserva");
        System.out.println("2 - Alterar reserva existente");
        System.out.println("3 - Excluir reserva");
        System.out.println("4 - Consultar reserva específica");
        System.out.println("5 - Listar todas as reservas");
        System.out.println("0 - Sair do sistema");
        System.out.println("=".repeat(50));
        System.out.print("Digite sua opção: ");
    }

    private static int lerOpcao() {
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            return opcao;
        } catch (NumberFormatException e) {
            return -1; // Retorna valor inválido para forçar nova entrada
        }
    }

    private static void incluirReserva() {
        System.out.println("\n=== INCLUIR NOVA RESERVA ===");

        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("Erro: Nome não pode estar vazio!");
            return;
        }

        System.out.print("Digite a data (dd/mm/aaaa): ");
        String data = scanner.nextLine().trim();

        if (!validarData(data)) {
            System.out.println("Erro: Data deve estar no formato dd/mm/aaaa!");
            return;
        }

        System.out.print("Digite a hora (hh:mm): ");
        String hora = scanner.nextLine().trim();

        if (!validarHora(hora)) {
            System.out.println("Erro: Hora deve estar no formato hh:mm!");
            return;
        }

        // Verificar se já existe reserva para a mesma data e hora
        if (verificarConflito(data, hora)) {
            System.out.println("Erro: Já existe uma reserva para esta data e hora!");
            return;
        }

        Reserva novaReserva = new Reserva(nome, data, hora);
        agenda.add(novaReserva);

        System.out.println("\n✓ Reserva incluída com sucesso!");
        System.out.println("Detalhes da reserva:");
        System.out.println(novaReserva.toString());
    }

    private static void alterarReserva() {
        System.out.println("\n=== ALTERAR RESERVA EXISTENTE ===");

        if (agenda.isEmpty()) {
            System.out.println("Não há reservas cadastradas para alterar.");
            return;
        }

        listarReservasComIndice();

        System.out.print("\nDigite o número da reserva que deseja alterar: ");
        try {
            int indice = Integer.parseInt(scanner.nextLine()) - 1;

            if (indice < 0 || indice >= agenda.size()) {
                System.out.println("Número de reserva inválido!");
                return;
            }

            Reserva reserva = agenda.get(indice);
            System.out.println("\nReserva atual:");
            System.out.println(reserva.toString());

            System.out.println("\nO que deseja alterar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Data");
            System.out.println("3 - Hora");
            System.out.println("4 - Todos os dados");
            System.out.print("Opção: ");

            int opcaoAlteracao = Integer.parseInt(scanner.nextLine());

            switch (opcaoAlteracao) {
                case 1:
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine().trim();
                    if (!novoNome.isEmpty()) {
                        reserva.setNome(novoNome);
                        System.out.println("✓ Nome alterado com sucesso!");
                    }
                    break;
                case 2:
                    System.out.print("Nova data (dd/mm/aaaa): ");
                    String novaData = scanner.nextLine().trim();
                    if (validarData(novaData)) {
                        if (!verificarConflito(novaData, reserva.getHora(), indice)) {
                            reserva.setData(novaData);
                            System.out.println("✓ Data alterada com sucesso!");
                        } else {
                            System.out.println("Erro: Conflito com reserva existente!");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nova hora (hh:mm): ");
                    String novaHora = scanner.nextLine().trim();
                    if (validarHora(novaHora)) {
                        if (!verificarConflito(reserva.getData(), novaHora, indice)) {
                            reserva.setHora(novaHora);
                            System.out.println("✓ Hora alterada com sucesso!");
                        } else {
                            System.out.println("Erro: Conflito com reserva existente!");
                        }
                    }
                    break;
                case 4:
                    alterarTodosDados(reserva, indice);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println("\nReserva atualizada:");
            System.out.println(reserva.toString());

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida!");
        }
    }

    private static void alterarTodosDados(Reserva reserva, int indice) {
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine().trim();

        System.out.print("Nova data (dd/mm/aaaa): ");
        String novaData = scanner.nextLine().trim();

        System.out.print("Nova hora (hh:mm): ");
        String novaHora = scanner.nextLine().trim();

        if (novoNome.isEmpty() || !validarData(novaData) || !validarHora(novaHora)) {
            System.out.println("Erro: Dados inválidos!");
            return;
        }

        if (verificarConflito(novaData, novaHora, indice)) {
            System.out.println("Erro: Conflito com reserva existente!");
            return;
        }

        reserva.setNome(novoNome);
        reserva.setData(novaData);
        reserva.setHora(novaHora);
        System.out.println("✓ Todos os dados alterados com sucesso!");
    }

    private static void excluirReserva() {
        System.out.println("\n=== EXCLUIR RESERVA ===");

        if (agenda.isEmpty()) {
            System.out.println("Não há reservas cadastradas para excluir.");
            return;
        }

        listarReservasComIndice();

        System.out.print("\nDigite o número da reserva que deseja excluir: ");
        try {
            int indice = Integer.parseInt(scanner.nextLine()) - 1;

            if (indice < 0 || indice >= agenda.size()) {
                System.out.println("Número de reserva inválido!");
                return;
            }

            Reserva reserva = agenda.get(indice);
            System.out.println("\nReserva a ser excluída:");
            System.out.println(reserva.toString());

            System.out.print("\nConfirma a exclusão? (s/n): ");
            String confirmacao = scanner.nextLine().trim().toLowerCase();

            if (confirmacao.equals("s") || confirmacao.equals("sim")) {
                agenda.remove(indice);
                System.out.println("✓ Reserva excluída com sucesso!");
            } else {
                System.out.println("Exclusão cancelada.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida!");
        }
    }

    private static void consultarReserva() {
        System.out.println("\n=== CONSULTAR RESERVA ESPECÍFICA ===");

        if (agenda.isEmpty()) {
            System.out.println("Não há reservas cadastradas para consultar.");
            return;
        }

        System.out.println("Buscar por:");
        System.out.println("1 - Nome");
        System.out.println("2 - Data");
        System.out.println("3 - Hora");
        System.out.println("4 - Busca geral (em todos os campos)");
        System.out.print("Opção: ");

        try {
            int tipoBusca = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o termo de busca: ");
            String termo = scanner.nextLine().trim();

            if (termo.isEmpty()) {
                System.out.println("Termo de busca não pode estar vazio!");
                return;
            }

            ArrayList<Reserva> resultados = new ArrayList<>();

            for (Reserva reserva : agenda) {
                boolean encontrou = false;

                switch (tipoBusca) {
                    case 1: // Busca por nome
                        encontrou = reserva.getNome().toLowerCase().contains(termo.toLowerCase());
                        break;
                    case 2: // Busca por data
                        encontrou = reserva.getData().contains(termo);
                        break;
                    case 3: // Busca por hora
                        encontrou = reserva.getHora().contains(termo);
                        break;
                    case 4: // Busca geral
                        encontrou = reserva.contem(termo);
                        break;
                    default:
                        System.out.println("Opção de busca inválida!");
                        return;
                }

                if (encontrou) {
                    resultados.add(reserva);
                }
            }

            if (resultados.isEmpty()) {
                System.out.println("\nNenhuma reserva encontrada com o termo: " + termo);
            } else {
                System.out.println("\n=== RESULTADOS DA BUSCA ===");
                System.out.println("Encontrada(s) " + resultados.size() + " reserva(s):");
                System.out.println("-".repeat(60));

                for (int i = 0; i < resultados.size(); i++) {
                    System.out.printf("%2d. %s%n", (i + 1), resultados.get(i).toString());
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida!");
        }
    }

    private static void listarTodasReservas() {
        System.out.println("\n=== LISTA DE TODAS AS RESERVAS ===");

        if (agenda.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        System.out.println("Total de reservas: " + agenda.size());
        System.out.println("-".repeat(60));

        for (int i = 0; i < agenda.size(); i++) {
            System.out.printf("%2d. %s%n", (i + 1), agenda.get(i).toString());
        }
    }

    private static void listarReservasComIndice() {
        System.out.println("\nReservas cadastradas:");
        System.out.println("-".repeat(60));

        for (int i = 0; i < agenda.size(); i++) {
            System.out.printf("%2d. %s%n", (i + 1), agenda.get(i).toString());
        }
    }

    private static boolean validarData(String data) {
        if (data == null || data.length() != 10) {
            return false;
        }

        String[] partes = data.split("/");
        if (partes.length != 3) {
            return false;
        }

        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);

            return dia >= 1 && dia <= 31 &&
                    mes >= 1 && mes <= 12 &&
                    ano >= 1900 && ano <= 2100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean validarHora(String hora) {
        if (hora == null || hora.length() != 5) {
            return false;
        }

        String[] partes = hora.split(":");
        if (partes.length != 2) {
            return false;
        }

        try {
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);

            return horas >= 0 && horas <= 23 &&
                    minutos >= 0 && minutos <= 59;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean verificarConflito(String data, String hora) {
        for (Reserva reserva : agenda) {
            if (reserva.getData().equals(data) && reserva.getHora().equals(hora)) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificarConflito(String data, String hora, int indiceExcluir) {
        for (int i = 0; i < agenda.size(); i++) {
            if (i != indiceExcluir) {
                Reserva reserva = agenda.get(i);
                if (reserva.getData().equals(data) && reserva.getHora().equals(hora)) {
                    return true;
                }
            }
        }
        return false;
    }
}
