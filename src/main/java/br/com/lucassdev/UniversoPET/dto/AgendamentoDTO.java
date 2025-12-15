package br.com.lucassdev.UniversoPET.dto;

import java.time.LocalDateTime;

import br.com.lucassdev.UniversoPET.model.Agendamento;
import br.com.lucassdev.UniversoPET.model.CategoriaServicos;
import br.com.lucassdev.UniversoPET.model.StatusAgendamento;

public record AgendamentoDTO(Long id,LocalDateTime dataHora, String observacoes, CategoriaServicos categoriaServicos, StatusAgendamento status, PetDTO pet, UsuarioDTO usuario) {
    public AgendamentoDTO(Agendamento agendamento) {
        this(agendamento.getId(), agendamento.getDataHora(), agendamento.getObservacoes(), agendamento.getCategoriaServicos(), agendamento.getStatus(), new PetDTO(agendamento.getPet()), new UsuarioDTO(agendamento.getUsuario()));
    }
}
