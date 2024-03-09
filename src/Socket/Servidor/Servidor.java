package Socket.Servidor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Servidor {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(3000);
             Socket socket = serverSocket.accept();
             InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
             PrintStream saida = new PrintStream(socket.getOutputStream());
             BufferedReader reader = new BufferedReader(inputReader)) {

            List<String> menuProdutos = List.of("Produto 1", "Produto 2", "Produto 3");

            System.out.println("Servidor Inicializado!");

            while (true) {
                String mensagem = reader.readLine();

                if (mensagem != null) {
                    switch (mensagem) {
                        case "1":
                            // Enviar o menu de produtos ao cliente
                            saida.println("==== Menu de Produtos ====");
                            for (String produto : menuProdutos) {
                                saida.println(produto);
                            }
                            saida.println("================================");
                            break;

                        case "2":
                            // Encerrar a conexão
                            System.out.println("Conexão encerrada pelo cliente.");
                            socket.close();
                            return;

                        default:
                            // Mensagem de opção inválida
                            saida.println("Cliente: Opção inválida. Tente novamente.");
                            break;
                    }

                    // Esperar um momento para permitir que o cliente processe a resposta
                    Thread.sleep(100);
                }
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
