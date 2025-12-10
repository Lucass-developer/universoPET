package br.com.lucassdev.UniversoPET.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucassdev.UniversoPET.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
