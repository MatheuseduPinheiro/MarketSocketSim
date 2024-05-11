<h1>MarketSocketSim</h1>

<p>Este é um projeto de simulação de um supermercado usando comunicação TCP entre um cliente e um servidor. O cliente simulado é responsável por interagir com o servidor para listar produtos, adicionar produtos ao carrinho e realizar outras operações típicas de um supermercado. O servidor, por sua vez, fornece os recursos necessários para atender às solicitações do cliente.</p>

<h2>Funcionalidades</h2>

<ul>
    <li>Listar Produtos: O cliente pode solicitar ao servidor a lista de todos os produtos disponíveis no supermercado&#9989.</li>
    <li>Adicionar Produto ao Carrinho: O cliente pode adicionar um produto ao carrinho, fornecendo o ID do produto desejado&#9989.</li>
    <li>Remover Produto do Carrinho:</li> O cliente pode remover um produto do carrinho, fornecendo o ID do produto a ser removido.
    <li>Visualizar Carrinho:</li> O cliente pode visualizar os produtos atualmente presentes no carrinho.
    <li>Finalizar Compra:</li> O cliente pode finalizar a compra, enviando o carrinho com os produtos escolhidos para o servidor processar o pagamento e concluir a transação.
</ul>

<h2>Como Usar</h2>

<ol>
    <li>Clone este repositório em sua máquina local.</li>
    <li>Execute o servidor e o cliente em instâncias separadas.</li>
    <li>Siga as instruções exibidas no cliente para interagir com o supermercado.</li>
</ol>

<h3>Executando o Servidor</h3>
<code>java Socket.Servidor.Servidor</code>

<h3>Executando o Cliente</h3>
<code>java Socket.Cliente.Cliente</code>
</html>
