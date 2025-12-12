package br.com.lucassdev.UniversoPET.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;
    private Boolean ativo;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;
    private BigDecimal total;

    public Pedido() {}

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
        this.dataPedido = LocalDateTime.now();
        this.dataEntrega = LocalDateTime.now().plusDays(7);
        this.ativo = true;
    }

    @Override
    public String toString() {
        return "Pedido " + id + " - " + usuario.getNome() + " - " + dataPedido + " - " + dataEntrega + " - " + total;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itensPedido) {
            total = total.add(item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }
        return total;   
    }
    
}
