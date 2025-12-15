package br.com.lucassdev.UniversoPET.dto;

import br.com.lucassdev.UniversoPET.model.CategoriaPet;

public record CadastroPetDTO(String nome, Integer idade, String categoriaPet, Long usuarioId) {

}
