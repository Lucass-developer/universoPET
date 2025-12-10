package br.com.lucassdev.UniversoPET.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    @ManyToMany
    private List<Produto> produtos;
    private Integer quantidade;
    private BigDecimal precoTotal;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;

    public Pedido() {}
    
}
