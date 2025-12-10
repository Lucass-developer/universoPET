package br.com.lucassdev.UniversoPET.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucassdev.UniversoPET.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
