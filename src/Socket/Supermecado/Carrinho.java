package Socket.Supermecado;


import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> itens;

    // Construtor
    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    // Método para adicionar um produto ao carrinho
    public void adicionarProduto(Produto produto) {
        itens.add(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    // Método para remover um produto do carrinho
    public void removerProduto(Produto produto) {
        if (itens.contains(produto)) {
            itens.remove(produto);
            System.out.println("Produto removido do carrinho: " + produto.getNome());
        } else {
            System.out.println("O produto não está no carrinho.");
        }
    }

    // Método para exibir os itens no carrinho
    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.println("Itens no Carrinho:");
            for (Produto produto : itens) {
                System.out.println(produto.exibirDetalhes());
            }
        }
    }

    // Método para calcular o total do carrinho
    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : itens) {
            total += produto.getPreco();
        }
        return total;
    }
}
