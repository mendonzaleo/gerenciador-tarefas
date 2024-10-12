package br.com.gerenciador.repository;

import br.com.gerenciador.model.Tarefa;
import br.com.gerenciador.util.Transacional;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class TarefaRepository implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    String termo;

    @Inject
    private EntityManager manager;

    public Tarefa porId(long id) {
        return manager.find(Tarefa.class, id);
    }

    public List<Tarefa> pesquisar(){
        TypedQuery<Tarefa> query = manager.createQuery("FROM Tarefa t WHERE t.titulo LIKE :termo OR t.descricao LIKE :termo", Tarefa.class);
        query.setParameter("termo", "%" + termo + "%");
        return query.getResultList();
    }

    @Transacional
    public Tarefa guardar(Tarefa tarefa) {
        return manager.merge(tarefa);
    }
    @Transacional
    public void remover(Tarefa tarefa) {
        tarefa = porId(tarefa.getId());
        manager.remove(tarefa);
    }

}
