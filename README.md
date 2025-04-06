import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== Configuração do Cliente P2P ===");
    System.out.print("IP do parceiro: ");
    String ip = scanner.nextLine();

    System.out.print("Porta do parceiro: ");
    int portaParceiro = scanner.nextInt();

    System.out.print("Porta para receber conexões: ");
    int minhaPorta = scanner.nextInt();

    new ClienteP2P(ip, portaParceiro, minhaPorta).iniciar();
  }
}
