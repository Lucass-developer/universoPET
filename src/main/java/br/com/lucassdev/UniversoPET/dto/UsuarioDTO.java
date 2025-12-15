package br.com.lucassdev.UniversoPET.dto;

import br.com.lucassdev.UniversoPET.model.Usuario;

public record UsuarioDTO(Long id, String nome, String email, String telefone) {
    public UsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }
}
