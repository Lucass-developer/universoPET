package br.com.lucassdev.UniversoPET.dto;

import br.com.lucassdev.UniversoPET.model.CategoriaPet;
import br.com.lucassdev.UniversoPET.model.Pet;
import br.com.lucassdev.UniversoPET.model.Usuario;

public record PetDTO(Long id, String nome, Integer idade, CategoriaPet categoriaPet, Usuario usuario) {
    public PetDTO(Pet pet) {
        this(pet.getId(), pet.getNome(), pet.getIdade(), pet.getCategoriaPet(), pet.getUsuario());
    }
}
