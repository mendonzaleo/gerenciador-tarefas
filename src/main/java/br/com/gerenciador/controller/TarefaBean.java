package br.com.gerenciador.controller;

import br.com.gerenciador.model.Prioridade;
import br.com.gerenciador.model.Responsavel;
import br.com.gerenciador.model.Tarefa;
import br.com.gerenciador.repository.TarefaRepository;
import br.com.gerenciador.service.CadastraTarefaService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class TarefaBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Tarefa tarefa = new Tarefa();

    public TarefaBean(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    private CadastraTarefaService cadastraTarefaService;

    public String getTitulo(){
        return tarefa.getTitulo();
    }
    public String getDescricao(){
        return tarefa.getDescricao();
    }
    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }
    public Responsavel[] getResponsavel() {
        return Responsavel.values();
    }
    public Date getData() {
        return tarefa.getDeadline();
    }
    public void salvarTarefa(Tarefa tarefa){
        cadastraTarefaService.salvar(tarefa);
    }
}
