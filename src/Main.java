
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);

    Cliente cliente = null;
    int opcao = 0;

    System.out.println("------Loja de Revistas Sunshine------");


    while (opcao != 5) {

      if (cliente == null) {
        System.out.print("Digite seu nome: ");
        String nomeInput = leitor.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpfInput = leitor.nextLine();

        if (nomeInput.trim().isEmpty() || cpfInput.trim().isEmpty()) {
          System.out.println("Erro: Cadastro obrigatório para continuar!");
          continue;
        }
        cliente = new Cliente(nomeInput, cpfInput);
        System.out.println("Bem-vindo(a), " + cliente.getNome() + "!");
      }


      System.out.println("\nO que deseja fazer?");
      System.out.println("1 - Alterar dados");
      System.out.println("2 - Consultar dados");
      System.out.println("3 - Excluir cadastro");
      System.out.println("4 - proceguir para as compras das revistas");
      System.out.println("5 - Sair do Sistema");
      System.out.print("Escolha: ");

      opcao = leitor.nextInt();
      leitor.nextLine();

      switch (opcao) {
        case 1:
          System.out.print("Novo nome: ");
          String n = leitor.nextLine();
          System.out.print("Novo CPF: ");
          String c = leitor.nextLine();
          cliente.atualizar(n, c);
          break;

        case 2:
          cliente.consultar();
          break;

        case 3:
          cliente.prepararExclusao();
          cliente = null;
          System.out.println("Cadastro excluído com sucesso!");
          break;

        case 4:
          System.out.println("\n---REVISTAS DISPONÍVEIS ---");
          System.out.println("1. Tecnologia e Futuro:");
          System.out.println("2. Esportes");
          System.out.println("3. Bem-Estar e Saúde");

          System.out.print("Escolha a numeração da revista: ");
          int num = leitor.nextInt();
          System.out.print("Quantidade desejada: ");
          int qtd = leitor.nextInt();
          leitor.nextLine();

          if (num >= 1 && num <= 3 && qtd > 0) {
            System.out.println("\n Pedido confirmado!");
            System.out.println("Espere a análise para pagamento.");
          } else {
            System.out.println("Revista ou quantidade inválida.");
          }
          break;

        case 5:
          System.out.println("Obrigado(a) pela preferência... Volte sempre à loja de revista Sunshine!");
          break;

        default:
          System.out.println("Opção inválida!");
      }
    }


    System.out.println("Bem-vindo a loja de revistas Sunshine");
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

      opcao = leitor.nextInt();
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