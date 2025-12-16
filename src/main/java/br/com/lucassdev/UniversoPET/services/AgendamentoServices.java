package br.com.lucassdev.UniversoPET.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassdev.UniversoPET.dto.AgendamentoDTO;
import br.com.lucassdev.UniversoPET.dto.CasdastrarAgendamentoDTO;
import br.com.lucassdev.UniversoPET.model.Agendamento;
import br.com.lucassdev.UniversoPET.model.Pet;
import br.com.lucassdev.UniversoPET.model.StatusAgendamento;
import br.com.lucassdev.UniversoPET.model.Usuario;
import br.com.lucassdev.UniversoPET.repository.AgendamentoRepository;
import br.com.lucassdev.UniversoPET.repository.PetRepository;
import br.com.lucassdev.UniversoPET.repository.UsuarioRepository;

@Service
public class AgendamentoServices {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void agendarConsulta(CasdastrarAgendamentoDTO agendamentoDTO) {
        try{
            Pet pet = petRepository.findById(agendamentoDTO.petId()).orElseThrow(() -> new IllegalArgumentException("Pet não encontrado"));
            Usuario usuario = usuarioRepository.findById(agendamentoDTO.usuarioId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
            Agendamento agendamento = new Agendamento(agendamentoDTO, usuario, pet);
            agendamentoRepository.save(agendamento);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao agendar consulta", e);
        }
    }

    public void cancelarAgendamento(AgendamentoDTO agendamentoDTO) {
        try{
            Agendamento agendamento = agendamentoRepository.findById(agendamentoDTO.id()).orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
            agendamento.setStatus(StatusAgendamento.CANCELADO);
            agendamentoRepository.save(agendamento);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cancelar agendamento", e);
        }
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }
}
