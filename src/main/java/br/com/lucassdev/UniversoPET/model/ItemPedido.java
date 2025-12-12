package br.com.lucassdev.UniversoPET.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "itens_pedidos")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @ManyToMany
    @JoinColumn(name = "produto_id")
    private List<Produto> produtos;
    private Integer quantidade;
    private BigDecimal precoUnitario;


    public ItemPedido() {}

    public ItemPedido(Pedido pedido, List<Produto> produtos, Integer quantidade, BigDecimal precoUnitario) {
        this.pedido = pedido;
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("informaçoes do Pedidos " + pedido.getId() + "\n");
        for (Produto produto : produtos) {
            sb.append(produto.getNome() + " - " + quantidade + " - " + precoUnitario + "\n");
        }
        sb.append("Total: " + pedido.getTotal() + "\n");
        sb.append("Data do Pedido: " + pedido.getDataPedido() + "\n");
        sb.append("Data de Entrega: " + pedido.getDataEntrega() + "\n");
        return sb.toString();
    }


    public Long getId() {
        return id;
    }


    public Pedido getPedido() {
        return pedido;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }


    public Integer getQuantidade() {
        return quantidade;
    }


    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    
}
