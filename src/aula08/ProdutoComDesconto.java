package aula08;

public class ProdutoComDesconto extends ProdutoGenerico {
    private double desconto;

    public ProdutoComDesconto(String nome, double preco, int stock, double desconto) {
        super(nome, preco, stock);
        this.desconto = desconto;
    }

    @Override
    public double getPreco() {
        return super.getPreco() * (1 - desconto / 100);
    }

    @Override
    public void adicionarQuantidade(int quantidade) {
        super.adicionarQuantidade(quantidade);
    }

    @Override
    public void removerQuantidade(int quantidade) {
        super.removerQuantidade(quantidade);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public int getQuantidade() {
        return super.getQuantidade();
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s, Preço: %.2f euros, Quantidade: %d, Desconto %.2f percento", getNome(),
                getPreco(),
                getQuantidade(), getDesconto());
    }

}
