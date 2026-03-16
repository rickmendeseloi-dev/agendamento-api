package com.Henrique.agendamento_api.controller;

import com.Henrique.agendamento_api.entity.Agendamento;
import com.Henrique.agendamento_api.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService service;

    @PostMapping
    public ResponseEntity<Agendamento> agendar(@RequestBody Agendamento novoAgendamento) {
        Agendamento salvo = service.salvar(novoAgendamento);
        return ResponseEntity.ok(salvo);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> lidarComErro(RuntimeException erro) {
        return ResponseEntity.badRequest().body(erro.getMessage());
    }
    @GetMapping
    public ResponseEntity<List<Agendamento>> listarTodos() {
        List<Agendamento> lista = service.buscarTodos();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody Agendamento dadosAtualizados) {
        Agendamento atualizado = service.atualizar(id, dadosAtualizados);
        return ResponseEntity.ok(atualizado);
    }
}
