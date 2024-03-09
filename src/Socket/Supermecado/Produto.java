package Socket.Supermecado;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id;
    private String nome;
    private double preco;

    // Construtor
    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(){
        
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Método para exibir os detalhes do produto
    public String exibirDetalhes() {
        return String.format("ID: %d | Nome: %s | Preço: R$ %.2f", id, nome, preco);
    }

    // Método para criar e retornar uma lista de produtos pré-instanciados
    public static List<Produto> getProdutosPreInstanciados() {
        List<Produto> produtos = new ArrayList<>();

        // Adicionando alguns produtos à lista
        produtos.add(new Produto(1, "Arroz", 5.99));
        produtos.add(new Produto(2, "Feijão", 4.50));
        produtos.add(new Produto(3, "Macarrão", 3.25));
        produtos.add(new Produto(4, "Leite", 2.99));
        produtos.add(new Produto(5, "Pão", 1.50));
        produtos.add(new Produto(6, "Saco de Torrada", 8.00));
        produtos.add(new Produto(7, "Coca-Cola", 5.00));
        produtos.add(new Produto(8, "Carne Moída", 12.99));
        produtos.add(new Produto(9, "Frango Congelado", 9.50));
        produtos.add(new Produto(10, "Ovos (dúzia)", 6.75));
        produtos.add(new Produto(11, "Maçãs (kg)", 4.25));
        produtos.add(new Produto(12, "Tomates (kg)", 3.99));
        produtos.add(new Produto(13, "Sabonete", 2.25));
        produtos.add(new Produto(14, "Shampoo", 7.50));
        produtos.add(new Produto(15, "Detergente", 1.75));
        produtos.add(new Produto(16, "Sabão em Pó", 9.99));
        produtos.add(new Produto(17, "Pasta de Dentes", 3.50));
        produtos.add(new Produto(18, "Biscoitos", 4.75));
        produtos.add(new Produto(19, "Queijo Prato", 8.50));
        produtos.add(new Produto(20, "Cerveja (lata)", 3.25));

        return produtos;
    }
}
