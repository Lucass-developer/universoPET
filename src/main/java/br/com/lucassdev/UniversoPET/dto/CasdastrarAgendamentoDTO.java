package br.com.lucassdev.UniversoPET.dto;

import java.time.LocalDateTime;

import br.com.lucassdev.UniversoPET.model.CategoriaServicos;

public record CasdastrarAgendamentoDTO(LocalDateTime dataHora, String observacoes, CategoriaServicos categoriaServicos, Long petId, Long usuarioId) {

}
