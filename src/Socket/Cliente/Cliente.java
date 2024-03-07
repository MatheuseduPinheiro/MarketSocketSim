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
        } catch (Exception e) {
            System.err.println("Servidor não autenticado");
        }

        // Aqui você pode colocar a lógica para enviar mensagens para o servidor
        try {
            PrintStream saida = new PrintStream(socket.getOutputStream());

            // Agora você pode obter entrada do teclado e enviar ao servidor
            while (true) {
                String teclado = input.nextLine();
                saida.println(teclado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
            socket.close();
        }
    }
}

