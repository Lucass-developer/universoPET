package br.com.lucassdev.UniversoPET.model;

import java.time.LocalDateTime;

import br.com.lucassdev.UniversoPET.dto.CasdastrarAgendamentoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    private LocalDateTime dataHora;
    private String observacoes;
    @Enumerated(EnumType.STRING)
    private CategoriaServicos categoriaServicos;
    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    public Agendamento() {}

    public Agendamento(CasdastrarAgendamentoDTO agendamentoDTO, Usuario usuario, Pet pet) {
        this.usuario = usuario;
        this.status = StatusAgendamento.AGENDADO;
        this.pet = pet;
        this.dataHora = agendamentoDTO.dataHora();
        this.observacoes = agendamentoDTO.observacoes();
        this.categoriaServicos = agendamentoDTO.categoriaServicos();
    }

    @Override
    public String toString() {
        return "Agendamento " + id + "\nUsuário: " + usuario.getNome() + "\nPet: " + pet.getNome() + "\nData e Hora: " + dataHora + "\nObservações: " + observacoes + "\nCategoria de Serviço: " + categoriaServicos + "\nStatus: " + status;
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

    public StatusAgendamento getStatus() {
        if(status == StatusAgendamento.CANCELADO) return StatusAgendamento.CANCELADO;
        if(LocalDateTime.now().isAfter(dataHora)) return StatusAgendamento.CONCLUIDO;
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

}
