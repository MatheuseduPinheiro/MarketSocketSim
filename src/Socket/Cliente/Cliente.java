package Socket.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 3000);
             Scanner input = new Scanner(System.in);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintStream saida = new PrintStream(socket.getOutputStream())) {

            System.out.println("Cliente conectado na porta 3000");
            ClienteThread clienteThread = new ClienteThread(socket);
            clienteThread.start();

            while (true) {
                // Exibir opções para o usuário
                System.out.println("Escolha uma opção:");
                System.out.println("1. Listar Produtos");
                System.out.println("2. Sair");

                System.out.print("Opção: ");
                String escolha = input.nextLine();

                // Verificar se a escolha é válida
                if ("1".equals(escolha) || "2".equals(escolha)) {
                    saida.println(escolha);

                    // Processar a escolha do servidor
                    String respostaServidor = entrada.readLine();
                    System.out.println(respostaServidor);

                    // Encerrar a conexão se o usuário escolher sair
                    if ("2".equals(escolha)) {
                        System.out.println("Encerrando a conexão...");
                        break;
                    }

                    // Aguardar um momento para permitir que o servidor processe a entrada
                    Thread.sleep(100);

                    // Limpar o buffer de entrada
                    entrada.readLine();
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao iniciar o cliente: " + e.getMessage());
        }
    }
}
