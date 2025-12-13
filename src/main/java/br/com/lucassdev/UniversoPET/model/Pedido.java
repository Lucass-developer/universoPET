package br.com.lucassdev.UniversoPET.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @OneToMany(mappedBy = "pedido")
    private List<itemPedido> itens = new ArrayList<>();

    public Pedido() {}

    public Pedido(Usuario usuario, List<itemPedido> itens) {
        this.usuario = usuario;
        this.dataPedido = LocalDateTime.now();
        this.dataEntrega = LocalDateTime.now().plusDays(7);
        this.ativo = true;
        this.status = StatusPedido.REALIZADO;
        this.itens = itens;
        this.total = itens.stream().map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade()))).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        return "Pedido " + id + " - " + usuario.getNome() + "\nData do Pedido: " + dataPedido + "\nPrevisao de Entrega: " + dataEntrega + "\nTotal:" + total;
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

    public StatusPedido getStatus() {
        if (dataEntrega.isBefore(LocalDateTime.now())) return StatusPedido.ENTREGUE;
        if (dataPedido.isBefore(dataPedido.plusDays(2))) return StatusPedido.ENVIADO;
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    
}
