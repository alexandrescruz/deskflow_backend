package com.example.deskflow.controller;

import com.example.deskflow.model.Chamado;
import com.example.deskflow.service.ChamadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
class ChamadoRestController {
    private final ChamadoService service;

    public ChamadoRestController(ChamadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Chamado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Chamado buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Chamado> criar(@RequestBody Chamado chamado) {
        Chamado chamadoSalvo = service.criar(chamado);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(chamadoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> atualizar(@PathVariable Long id, @RequestBody Chamado novoChamado) {
        Chamado novoChamadoSalvo = service.atualizar(id,novoChamado);
        return ResponseEntity.status(HttpStatus.OK)
                .body(novoChamadoSalvo);
    }

    @GetMapping("/status/{status}")




}
