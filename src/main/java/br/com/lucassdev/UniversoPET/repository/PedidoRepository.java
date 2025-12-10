package br.com.lucassdev.UniversoPET.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucassdev.UniversoPET.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
