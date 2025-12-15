package br.com.lucassdev.UniversoPET.dto;

import br.com.lucassdev.UniversoPET.model.Estoque;

public record EstoqueDTO(Long produtoId, Integer quantidade) {
    public EstoqueDTO(Estoque estoque) {
        this(estoque.getProduto().getId(), estoque.getQuantidade());
    }
}
