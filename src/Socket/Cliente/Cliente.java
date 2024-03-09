package Socket.Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ConnectException;  // Importe a exceção de conexão para tratá-la adequadamente
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            Scanner input = new Scanner(System.in);
            System.out.println("Bem Vindo ao Caixa");
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

            input.close();
            socket.close();
        } catch (ConnectException e) {
            System.err.println("Erro ao conectar ao servidor na porta 3000: Servidor não encontrado.");
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o cliente: " + e.getMessage());
        }
    }
}
