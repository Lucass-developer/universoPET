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
        this.quantidade = produto.getEstoqueInicial();
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + " (" + produto.getId() + ") Quantidade: " + quantidade + "ID do estoque: " + id;
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
}
