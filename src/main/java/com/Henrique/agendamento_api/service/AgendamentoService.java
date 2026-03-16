package com.Henrique.agendamento_api.service;

import com.Henrique.agendamento_api.repository.AgendamentoRepository;
import com.Henrique.agendamento_api.entity.Agendamento;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;
    
    public Agendamento salvar(Agendamento novoAgendamento){
        Optional<Agendamento> horarioOcupado = repository.findByDataHora(novoAgendamento.getDataHora());
        if (horarioOcupado.isPresent()) {
            throw new RuntimeException("Horário já ocupado. Por favor, escolha outro horário.");
        }
        return repository.save(novoAgendamento);
    }
    public List<Agendamento> buscarTodos() {
        return repository.findAll();
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    public Agendamento atualizar(Long id, Agendamento dadosAtualizados) {
        Agendamento agendamentoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado!"));

        agendamentoExistente.setCliente(dadosAtualizados.getCliente());
        agendamentoExistente.setServico(dadosAtualizados.getServico());
        agendamentoExistente.setDataHora(dadosAtualizados.getDataHora());

        return repository.save(agendamentoExistente);
    }
}
