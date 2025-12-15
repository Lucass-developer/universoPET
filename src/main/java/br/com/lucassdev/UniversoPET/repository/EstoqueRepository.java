package br.com.lucassdev.UniversoPET.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucassdev.UniversoPET.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
