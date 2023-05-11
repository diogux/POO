package aula08;

import java.util.ArrayList;

public class CarrinhoDeCompras implements Compra {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private double total;

    @Override
    public void adicionarProduto(Produto p, int quantidade) {
        p.adicionarQuantidade(quantidade);
        produtos.add(p);
    }

    @Override
    public void listarProdutos() {
        for (Produto p : produtos) {
            if (p instanceof ProdutoComDesconto) {
                ProdutoComDesconto pd = (ProdutoComDesconto) p;
                System.out.println(pd);
            } else {
                System.out.printf("Produto: %s, Preço: %.2f euros, Quantidade: %d\n", p.getNome(), p.getPreco(),
                        p.getQuantidade());
            }

        }
    }

    @Override
    public double calcularTotal() {
        for (Produto p : produtos) {
            total += p.getPreco() * p.getQuantidade();
        }
        return total;
    }

}
