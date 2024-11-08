import java.util.Scanner;

public class AgendaConsole {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nAgenda");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Editar Contato");
            System.out.println("4. Remover Contato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    agenda.adicionarContato(new Contato(nome, telefone, email));
                }
                case 2 -> agenda.listarContatos();
                case 3 -> {
                    System.out.print("Índice do contato a editar: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Novo email: ");
                    String email = scanner.nextLine();
                    agenda.editarContato(index, nome, telefone, email);
                }
                case 4 -> {
                    System.out.print("Índice do contato a remover: ");
                    int index = scanner.nextInt();
                    agenda.removerContato(index);
                }
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
        scanner.close();
    }
}
