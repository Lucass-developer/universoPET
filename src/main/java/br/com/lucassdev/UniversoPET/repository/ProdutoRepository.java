package br.com.lucassdev.UniversoPET.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucassdev.UniversoPET.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
