import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageReceiver implements Runnable {
  private final int porta;

  public MessageReceiver(int porta) {
    this.porta = porta;
  }

  @Override
  public void run() {
    try (ServerSocket serverSocket = new ServerSocket(porta)) {
      System.out.println("Servidor P2P ouvindo na porta " + porta);
      Socket socket = serverSocket.accept();

      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      String mensagem;
      while ((mensagem = in.readLine()) != null) {
        System.out.println("Recebido: " + mensagem);
      }
    } catch (Exception e) {
      System.out.println("Erro no receptor: " + e.getMessage());
    }
  }
}