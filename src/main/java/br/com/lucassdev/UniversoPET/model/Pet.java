package br.com.lucassdev.UniversoPET.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Boolean ativo;

    public Pet() {}

    @Override
    public String toString() {
        return "Pet " + id + " - " + nome + " - " + categoriaPet.getCategoriaPet() + " - " + idade + " - " + usuario.getNome();
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

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
