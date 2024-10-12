package br.com.gerenciador.controller;

import br.com.gerenciador.model.Prioridade;
import br.com.gerenciador.model.Tarefa;
import br.com.gerenciador.repository.TarefaRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class TarefaBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Tarefa tarefa = new Tarefa();
    @Inject
    private TarefaRepository tarefaRepository;

    public Tarefa getTarefa() {
        return tarefa;
    }

    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }

    private List<Tarefa> tarefas = new ArrayList<Tarefa>();

    public void salvarTarefa() {
        tarefaRepository.guardar(tarefa);
    }

    public List<Tarefa> getTarefas() {
        if (tarefas == null) {
            tarefas = tarefaRepository.pesquisar();
        }
        return tarefas;
    }

    public void excluir(Tarefa tarefa) {
        tarefaRepository.remover(tarefa);
        tarefas = tarefaRepository.pesquisar();
    }

}
