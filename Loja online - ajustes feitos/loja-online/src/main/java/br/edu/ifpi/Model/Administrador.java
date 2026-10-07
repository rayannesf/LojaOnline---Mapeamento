package br.edu.ifpi.Model;
public class Administrador extends Usuario {


    public void adicionarProduto(Produto produto) {
        System.out.println("Produto adicionado.");
    }

    public void removerProduto(Produto produto) {
        System.out.println("Produto removido.");
    }

    public void visualizarPedidos() {
        System.out.println("Visualizando pedidos.");
    }
}