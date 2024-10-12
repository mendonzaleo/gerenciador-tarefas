package br.com.gerenciador.service;

import br.com.gerenciador.model.Tarefa;
import br.com.gerenciador.repository.TarefaRepository;
import br.com.gerenciador.util.Transacional;
import jakarta.inject.Inject;

import java.io.Serializable;


public class CadastraTarefaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TarefaRepository tarefas;

    @Transacional
    public void salvar(Tarefa tarefa) {
        tarefas.guardar(tarefa);
    }

    @Transacional
    public void excluir(Tarefa tarefa) {
        tarefas.remover(tarefa);
    }


}
