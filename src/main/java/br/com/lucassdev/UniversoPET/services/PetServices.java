package br.com.lucassdev.UniversoPET.services;

import org.springframework.stereotype.Service;

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

    public void excluirPet(Long petId) {
        try{
            Pet pet = petRepository.findById(petId).orElseThrow(() -> new IllegalArgumentException("Pet não encontrado"));
            pet.setAtivo(false);
            petRepository.save(pet);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir pet", e);
        }
    }

}
