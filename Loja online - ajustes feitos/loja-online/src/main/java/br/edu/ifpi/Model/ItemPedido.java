package br.edu.ifpi.Model;
public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private Pedido pedido;


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
