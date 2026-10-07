package br.edu.ifpi.Model;

import br.edu.ifpi.Interfaces.Pagamento;

public class Boleto implements Pagamento {

    private String codigoBarras;

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public boolean processarPagamento(double valor) {

        System.out.println("Pagamento por boleto.");
        System.out.println("Valor: R$ " + valor);

        return true;
    }
}