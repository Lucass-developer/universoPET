package br.com.lucassdev.UniversoPET.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private CategoriaPet categoriaPet;
    private int idade;
    @ManyToOne
    private Usuario usuario;
    private Boolean ativo;

    public Pet() {}

    public Pet(String nome, CategoriaPet categoriaPet, int idade, Usuario usuario) {
        this.nome = nome;
        this.categoriaPet = categoriaPet;
        this.idade = idade;
        this.usuario = usuario;
        this.ativo = true;
    }

    @Override
    public String toString() {
        return "Pet " + id + " - " + nome + " - " + categoriaPet + " - " + idade + " - " + usuario.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaPet getCategoriaPet() {
        return categoriaPet;
    }

    public int getIdade() {
        return idade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
