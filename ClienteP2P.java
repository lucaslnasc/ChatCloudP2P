import java.io.IOException;
import java.net.Socket;

public class ClienteP2P {
    private final String ipDestino;
    private final int portaDestino;
    private final int minhaPorta;

    public ClienteP2P(String ipDestino, int portaDestino, int minhaPorta) {
        this.ipDestino = ipDestino;
        this.portaDestino = portaDestino;
        this.minhaPorta = minhaPorta;
    }

    public void iniciar() {
        try {
            new Thread(new MessageReceiver(minhaPorta)).start();
            Thread.sleep(2000);
            Socket socket = new Socket(ipDestino, portaDestino);
            System.out.println("Conexão estab elecida com " + ipDestino + ":" + portaDestino);
            new MessageSender(socket).run();
        } catch (IOException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread interrompida: " + e.getMessage());
        }
    }
}