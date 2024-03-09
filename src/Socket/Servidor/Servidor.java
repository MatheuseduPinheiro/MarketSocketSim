package Socket.Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {

        try {
            // Definir a porta
            ServerSocket serverSocket = new ServerSocket(3000);

            // Pegar a informação da conexão
            Socket socket = serverSocket.accept();
            System.out.println("Servidor Inicializado!");
            // Ler as informações e mandar de volta para o cliente
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            PrintStream saida = new PrintStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(inputReader);
            String mensagem;

            while ((mensagem = reader.readLine()) != null) {
             
                System.out.println("Mensagem do cliente: " + mensagem);
                saida.println(mensagem);
                
            }

        } catch (Exception e) {
            System.err.println("Servidor não autenticado");
        }
    }
}
