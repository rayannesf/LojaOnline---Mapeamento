package br.edu.ifpi.Model;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.Interfaces.Pagamento;

public class Pedido {

    private int numeroPedido;
    private String status;
    private List<ItemPedido> itens;
    private Pagamento pagamento;


    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {

        double total = 0;

        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }

        return total;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getStatus() {
        return status;
    }
}
