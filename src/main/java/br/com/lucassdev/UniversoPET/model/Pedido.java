package br.com.lucassdev.UniversoPET.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    public Pedido() {}

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
        this.dataPedido = LocalDateTime.now();
        this.dataEntrega = LocalDateTime.now().plusDays(7);
        this.ativo = true;
        this.status = StatusPedido.RECEBIDO;
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
