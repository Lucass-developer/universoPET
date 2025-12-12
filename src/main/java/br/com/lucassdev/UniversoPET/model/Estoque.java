package br.com.lucassdev.UniversoPET.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estoques")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private Integer quantidade;

    public Estoque() {}

    public Estoque(Produto produto) {
        this.produto = produto;
        this.quantidade = produto.getQuantidadeEstoque();
    }

    @Override
    public String toString() {
        return "Estoque do Produto " + produto.getNome() + " - ID: " + id + " - Quantidade: " + quantidade;
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(Integer quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(Integer quantidade) {
        this.quantidade -= quantidade;
    }
}
