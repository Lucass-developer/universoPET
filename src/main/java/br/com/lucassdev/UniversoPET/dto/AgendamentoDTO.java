package br.com.lucassdev.UniversoPET.dto;

import java.time.LocalDateTime;

import br.com.lucassdev.UniversoPET.model.CategoriaServicos;
import br.com.lucassdev.UniversoPET.model.StatusAgendamento;

public record AgendamentoDTO(Long id,LocalDateTime dataHora, String observacoes, CategoriaServicos categoriaServicos, StatusAgendamento status, PetDTO pet, CadastroUsuarioDTO usuario) {

}
