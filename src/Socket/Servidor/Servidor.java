package Socket.Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import Socket.Supermecado.Carrinho;
import Socket.Supermecado.Produto;

public class Servidor {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(3000);
                Socket socket = serverSocket.accept();
                InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
                PrintStream saida = new PrintStream(socket.getOutputStream());
                BufferedReader reader = new BufferedReader(inputReader)) {

            List<Produto> menuProdutos = Produto.getProdutosPreInstanciados();
            Carrinho carrinho = new Carrinho();

            System.out.println("Servidor Inicializado!");

            while (true) {
                String mensagem = reader.readLine();

                if (mensagem != null) {
                    switch (mensagem) {
                        case "1":
                            // Enviar o menu de produtos ao cliente
                            saida.println("===== Menu de Produtos =====");
                            for (Produto produto : menuProdutos) {
                                saida.println(produto.exibirDetalhes());
                            }
                            saida.println("================================");
                            System.out.println("Produtos disponiveis enviados ao Cliente");
                            break;

                        case "2":
                            // Encerrar a conexão
                            System.out.println("Conexão encerrada pelo cliente.");
                            socket.close();
                            return;

                        case "3":
                            // Receber o ID do produto enviado pelo cliente
                            String idProduto = reader.readLine();
                            int id = Integer.parseInt(idProduto);

                            // Inicialmente, consideramos que o produto não foi encontrado
                            Produto produtoSelecionado = null;

                            // Procurar o produto correspondente na lista de produtos disponíveis
                            for (Produto produto : menuProdutos) {
                                if (produto.getId() == id) {
                                    produtoSelecionado = produto;
                                    break; // Sai do loop assim que encontra o produto
                                }
                            }

                            // Adicionar o produto ao carrinho do cliente, se encontrado
                            if (produtoSelecionado != null) {
                                carrinho.adicionarProduto(produtoSelecionado);
                                saida.println("Produto adicionado ao carrinho: " + produtoSelecionado.getNome());
                            } else {
                                // Se o produto não foi encontrado, envie uma mensagem adequada para o cliente
                                saida.println("Produto não encontrado.");
                            }
                            break;

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
