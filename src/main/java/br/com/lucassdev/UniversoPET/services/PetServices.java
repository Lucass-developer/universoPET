package br.com.lucassdev.UniversoPET.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassdev.UniversoPET.dto.CadastroPetDTO;
import br.com.lucassdev.UniversoPET.model.Pet;
import br.com.lucassdev.UniversoPET.model.Usuario;
import br.com.lucassdev.UniversoPET.repository.PetRepository;
import br.com.lucassdev.UniversoPET.repository.UsuarioRepository;

@Service
public class PetServices {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Pet> listarTodos() {
        return petRepository.findAll();
    }

    public void cadastrarPet(CadastroPetDTO petDTO) {
        try{
            Usuario usuario = usuarioRepository.findById(petDTO.usuarioId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
            Pet pet = new Pet(petDTO, usuario);
            petRepository.save(pet);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar pet", e);
        }
    }

    public void desativarPet(Long petId) {
        try{
            Pet pet = petRepository.findById(petId).orElseThrow(() -> new IllegalArgumentException("Pet não encontrado"));
            pet.setAtivo(false);
            petRepository.save(pet);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao desativar pet", e);
        }
    }

}
