package Socket.Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Cliente conectado na porta 3000");
            ClienteThread clienteThread = new ClienteThread(socket);
            clienteThread.start();

            // Agora você pode obter entrada do teclado e enviar ao servidor
            PrintStream saida = new PrintStream(socket.getOutputStream());
            while (true) {
                System.out.print("-> ");  // Indicação visual
                String teclado = input.nextLine();
                saida.println(teclado);

                // Adicionado o encerramento da conexão quando o usuário digitar "exit" ou "quit"
                if ("exit".equalsIgnoreCase(teclado) || "quit".equalsIgnoreCase(teclado)) {
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o cliente: " + e.getMessage());
        } finally {
            input.close();
            socket.close();
        }
    }
}
