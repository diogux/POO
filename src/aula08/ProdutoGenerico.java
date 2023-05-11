package aula08;

public class ProdutoGenerico implements Produto {
    private String nome;
    private double preco;
    private int stock;

    public ProdutoGenerico(String nome, double preco, int stock) {
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override   
    public double getPreco() {
        return preco;
    }

    @Override
    public int getQuantidade() {
        return stock;
    }

    @Override
    public void adicionarQuantidade(int quantidade) {
        stock += quantidade;
    }

    @Override
    public void removerQuantidade(int quantidade) {
        if (quantidade > stock) stock = 0;
        else stock -= quantidade;
        

    }

}

