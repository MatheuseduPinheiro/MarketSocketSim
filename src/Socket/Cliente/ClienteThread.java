package Socket.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread extends Thread {

    private Socket socket;

    public ClienteThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Ler as informações e mandar de volta para o cliente
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputReader);
            String mensagem;

            while ((mensagem = reader.readLine()) != null) {
                System.out.println("Cliente: " + mensagem);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
