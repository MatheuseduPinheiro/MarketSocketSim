package Socket.Supermecado;
import Socket.Supermecado.Produto;
import java.util.List;

public class Menu {

    public static void main(String[] args) {
        // Obter a lista de produtos pré-instanciados
        List<Produto> produtos = Produto.getProdutosPreInstanciados();

        // Exibir o menu
        System.out.println("=== Lista de Produtos ===");
        for (Produto produto : produtos) {
            System.out.println(produto.exibirDetalhes());
        }
    }
}
