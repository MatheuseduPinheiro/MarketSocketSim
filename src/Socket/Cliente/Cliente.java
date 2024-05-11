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
                System.out.println("3. Adicionar item ao Carrinho pelo ID");
                System.out.println("4: Remover item do Carrinho pelo ID");
                System.out.println("5: Visualizar itens ao Carrinho pelo ID");

                System.out.print("Opção: ");
                String escolha = input.nextLine();

                // Verificar se a escolha é válida
                if ("1".equals(escolha) || "2".equals(escolha) || "3".equals(escolha) || "4".equals(escolha) || "5".equals(escolha)) {
                    saida.println(escolha);

                    if ("3".equals(escolha)) {
                        // Processar adição de produto ao carrinho
                        System.out.print("Digite o ID do produto que deseja adicionar ao carrinho: ");
                        String idProduto = input.nextLine();
                        saida.println(idProduto);

                        continue;
                    }

                    // Processar a escolha do servidor
                    String respostaServidor = entrada.readLine();
                    System.out.println(respostaServidor);

                    // Encerrar a conexão se o usuário escolher sair
                    if ("2".equals(escolha)) {
                        System.out.println("Encerrando a conexão...");
                        break;
                    }

                    if ("4".equals(escolha)) {
                        // Processar remoção de produto do carrinho
                        System.out.print("Digite o ID do produto que deseja remover do carrinho: ");
                        String idProdutoRemover = input.nextLine();
                        saida.println(idProdutoRemover);
                        break;
                    }

                    if ("5".equals(escolha)) {
                        // Enviar a escolha do cliente para o servidor
                        saida.println(escolha);
                    }

                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }

            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o cliente: " + e.getMessage());
        }
    }
}
