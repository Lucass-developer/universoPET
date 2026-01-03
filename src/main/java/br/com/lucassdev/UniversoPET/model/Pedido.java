package br.com.lucassdev.UniversoPET.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private Boolean ativo;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido() {}

    public Pedido(Usuario user) {
        this.usuario = user;
        this.dataPedido = LocalDate.now();
        this.dataEntrega = LocalDate.now().plusDays(7);
        this.ativo = true;
        this.status = StatusPedido.RECEBIDO;
        this.total = BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pedido ")
        .append(id)
        .append(" - ")
        .append(usuario.getNome())
        .append("\nData do Pedido: ")
        .append(dataPedido)
        .append("Previsao de Entrega: ")
        .append(dataEntrega)
        .append(" Status do pedido: ")
        .append(getStatus())
        .append("\nItens:")
        .append("\n");

        for (ItemPedido i : itens) {
            sb.append(i.getProduto().getNome())
            .append(" - Quantidade: ")
            .append(i.getQuantidade())
            .append(" - SubTotal: R$")
            .append(String.format("%.2f", i.getSubTotal()))
            .append("\n");
        }

        sb.append("Total: R$")
        .append(String.format("%.2f", getTotal()));

        return sb.toString();
    }


    public BigDecimal getTotal() {
        this.total = BigDecimal.ZERO;
        for (ItemPedido i : itens) total = total.add(i.getSubTotal());
        return total;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public StatusPedido getStatus() {
        if (dataEntrega.isBefore(LocalDate.now()) || dataEntrega.isEqual(LocalDate.now())) return StatusPedido.ENTREGUE;
        if (dataPedido.isAfter(dataPedido.plusDays(2))) return StatusPedido.ENVIADO;
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setItemPedido(ItemPedido item) {
        this.itens.add(item);
        item.setPedido(this);
    }
    
}
