package br.com.lucassdev.UniversoPET.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Boolean ativo;
    @OneToMany(mappedBy = "usuario")
    private List<Pet> pets;
    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentos;
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;
    private Boolean administrador;
    
    public Usuario() {}

    public Usuario(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.ativo = true;
        this.administrador = false;
    }

    @Override
    public String toString() {
        return "Usuario " + id + "\nNome: " + nome + "\nEmail: " + email + "\nTelefone: " + telefone + "\nAtivo: " + ativo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

     public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }


    
}
