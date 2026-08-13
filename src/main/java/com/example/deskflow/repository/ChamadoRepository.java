package com.example.deskflow.repository;

import com.example.deskflow.enums.PrioridadeChamado;
import com.example.deskflow.enums.StatusChamado;
import com.example.deskflow.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    List<Chamado> findByStatus(StatusChamado status);
    List<Chamado> findByPrioridade(PrioridadeChamado prioridade);
    List<Chamado> findByStatusAndPrioridade(StatusChamado status, PrioridadeChamado prioridade);
    Long countByStatus(StatusChamado status);
}
