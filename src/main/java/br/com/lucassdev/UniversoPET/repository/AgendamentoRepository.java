package br.com.lucassdev.UniversoPET.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucassdev.UniversoPET.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
