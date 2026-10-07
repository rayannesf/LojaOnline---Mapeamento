package br.edu.ifpi.Model;
public abstract class  Produto {

    protected String nome;
    protected double preco;
    protected String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}
