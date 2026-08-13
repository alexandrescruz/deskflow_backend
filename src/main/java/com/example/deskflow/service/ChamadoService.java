package com.example.deskflow.service;

import com.example.deskflow.exception.ChamadoNaoEncontradoException;
import com.example.deskflow.model.Chamado;
import com.example.deskflow.repository.ChamadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {
    private final ChamadoRepository repository;

    public ChamadoService(ChamadoRepository repository){
        this.repository = repository;
    }

    public List<Chamado> listar() {
        return repository.findAll();
    }

    public Chamado buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ChamadoNaoEncontradoException("Chamado não entrado:"+ id));
    }



    public Chamado criar(Chamado chamado) {
        repository.save(chamado);
        return chamado;
    }

    public Chamado atualizar(Long id,Chamado novosDados) {
        Chamado chamado = buscarPorId(id);
        chamado.setDescricao(novosDados.getDescricao());
        chamado.setTitulo(novosDados.getTitulo());
        chamado.setPrioridade(novosDados.getPrioridade());
        chamado.setStatus(novosDados.getStatus());
        Chamado novoChamado = repository.save(chamado);
        return novoChamado;
    }

}
