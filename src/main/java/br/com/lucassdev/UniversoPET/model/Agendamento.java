package br.com.lucassdev.UniversoPET.model;

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
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Pet pet;
    private LocalDateTime dataHora;
    private String observacoes;
    @Enumerated(EnumType.STRING)
    private CategoriaServicos categoriaServicos;

    public Agendamento() {}

    public Agendamento(Usuario usuario, Pet pet, LocalDateTime dataHora, String observacoes,
            CategoriaServicos categoriaServicos) {
        this.usuario = usuario;
        this.pet = pet;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
        this.categoriaServicos = categoriaServicos;
    }

    @Override
    public String toString() {
        return "Agendamento " + id + " - " + usuario + " - " + pet + " - " + dataHora
                + " - " + observacoes + " - " + categoriaServicos;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Pet getPet() {
        return pet;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public CategoriaServicos getCategoriaServicos() {
        return categoriaServicos;
    }
    
}
