package Menu;



import java.util.Scanner;

import Modelo.Cliente;
import Servicos.ClienteS;

public class Menu {
    public static void menu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int op;
        ClienteS ClienteS = new ClienteS();

        do{
            System.out.println("---------- MENU CLIENTE--------");
            System.out.println("---------- 1-Criar     --------");
            System.out.println("---------- 2-Ler       --------");
            System.out.println("---------- 3-Atualizar --------");
            System.out.println("---------- 4-Remover ----------");
            System.out.println("---------- 5-Sair -------------");
            System.out.println("Escolha uma opcao:");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    Scanner scan = new Scanner(System.in);

                    String nome = null;
                    String email = null;
                    String telefone = null;

                    System.out.println("------ CRIAR CLIENTE ------");
                    System.out.println("Insira o nome:  ");
                    nome = scan.nextLine();

                    System.out.println("Insira o email: ");
                    email = scan.nextLine();

                    System.out.println("Insira o numero de telefone: ");
                    telefone = scan.nextLine();

                    ClienteS.criarCliente(nome, email, telefone);
                    break;
                case 2:
                    System.out.println("------ LISTA DOS CLIENTES --------");
                    ClienteS.lerClientes();
                    break;
                case 3:
                    System.out.println("-------- ATUALIZAR CLIENTE -------");
                    System.out.println("Insira o id do cliente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Insira o nome:  ");
                    nome = scanner.nextLine();

                    System.out.println("Insira o email: ");
                    email = scanner.nextLine();

                    System.out.println("Insira o numero de telefone: ");
                    telefone = scanner.nextLine();

                    ClienteS.atualizarCliente(id, nome, email, telefone);
                    break;
                case 4:
                    System.out.println("----- REMOVER CLIENTE -------");
                    System.out.println("Insira o id: ");
                    id = scanner.nextInt();

                    ClienteS.removerCliente(id);
                    break;
                case 5:
                    System.out.println("Adeus!!");
                    break;
                default:
                    System.out.println("Numero invalido");
                    break;
            }

        }while(op != 5);
        scanner.close();
    }
}
