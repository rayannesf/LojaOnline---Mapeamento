package br.edu.ifpi.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario {

    @Column(nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", unique = true)
    private Endereco endereco;

    // Construtor padrão exigido pelo JPA.
    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
        if (endereco != null && endereco.getCliente() != this) {
            endereco.setCliente(this);
        }
    }
}
