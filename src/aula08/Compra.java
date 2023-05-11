package aula08;

public interface Compra {
    void adicionarProduto(Produto p, int quantidade);
    void listarProdutos();
    double calcularTotal(); // usei double, pois no teste é necessário para funcionar
}
