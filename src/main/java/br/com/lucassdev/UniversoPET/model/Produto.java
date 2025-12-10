package br.com.lucassdev.UniversoPET.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private CategoriaProdutos categoriaProdutos;
    private Integer quantidadeEstoque;
    private Boolean ativo;

    @ManyToMany(mappedBy = "produtos")
    @JoinColumn(name = "pedido_id")
    private List<Pedido> pedidos;
    
    public Produto() {}

    public Produto(String nome, String descricao, BigDecimal preco, CategoriaProdutos categoriaProdutos, Integer quantidadeEstoque, Boolean ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaProdutos = categoriaProdutos;
        this.quantidadeEstoque = quantidadeEstoque;
        this.ativo = ativo;
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

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Boolean getAtivo() {
        return ativo;
    }

}
