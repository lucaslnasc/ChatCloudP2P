import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender implements Runnable {
  private final Socket socket;

  public MessageSender(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(
            new InputStreamReader(System.in))) {

      System.out.println("Digite suas mensagens (Ctrl+C para sair):");
      String mensagem;
      while ((mensagem = console.readLine()) != null) {
        out.println(mensagem);
      }
    } catch (Exception e) {
      System.out.println("Erro no envio: " + e.getMessage());
    }
  }
}