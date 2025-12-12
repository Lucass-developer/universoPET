package br.com.lucassdev.UniversoPET.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private CategoriaProdutos categoriaProdutos;
    @Transient
    private Integer quantidadeEstoque;
    private Boolean ativo;
    
    public Produto() {}

    public Produto(String nome, String descricao, BigDecimal preco, CategoriaProdutos categoriaProdutos, Integer quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaProdutos = categoriaProdutos;
        this.quantidadeEstoque = quantidadeEstoque;
        this.ativo = true;
    }

    @Override
    public String toString() {
        return "Produto " + id + " - " + nome + " - " + descricao + " - " + preco + " - " + categoriaProdutos;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public CategoriaProdutos getCategoriaProdutos() {
        return categoriaProdutos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}
