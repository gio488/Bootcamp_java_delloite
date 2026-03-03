//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Bem vindo a loja de revistas");
        System.out.print("Digite seu nome: ");
        String nomeCliente = leitor.nextLine();

        if (nomeCliente.trim().isEmpty()) {
            System.out.println("Erro: O nome não pode estar vazio!");
        } else {
            System.out.println("Olá, " + nomeCliente + "!");

            System.out.println("\nO que deseja fazer?");
            System.out.println("1 - Alterar nome");
            System.out.println("2 - Excluir cadastro");
            System.out.println("3 - Continuar");

            int opcao = leitor.nextInt();
            leitor.nextLine();


            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    nomeCliente = leitor.nextLine();
                    System.out.println("Nome alterado para: " + nomeCliente);
                    break;
                case 2:
                    nomeCliente = null;
                    System.out.println("Cadastro excluído com sucesso.");
                    break;
                case 3:
                    System.out.println("Prosseguindo para as revistas...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        if (nomeCliente != null) {
            System.out.println("Obrigado pela preferência, " + nomeCliente);
        }

        leitor.close();
    }
}