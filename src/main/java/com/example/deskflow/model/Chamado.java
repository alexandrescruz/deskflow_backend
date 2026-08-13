package com.example.deskflow.model;

import com.example.deskflow.enums.PrioridadeChamado;
import com.example.deskflow.enums.StatusChamado;
import jakarta.persistence.*;

@Entity
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusChamado status;
    @Enumerated(EnumType.STRING)
    private PrioridadeChamado prioridade;

    public Chamado() {}
    public Long getId(){return id;}
    public String getTitulo() {return this.titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getDescricao() {return this.descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public StatusChamado getStatus() {return this.status; }

    public void setStatus(StatusChamado status) {this.status = status;}

    public PrioridadeChamado getPrioridade() {return this.prioridade; }

    public void setPrioridade(PrioridadeChamado prioridade) {this.prioridade = prioridade;}







}
