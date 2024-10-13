package br.com.gerenciador.repository;

import br.com.gerenciador.model.Tarefa;
import br.com.gerenciador.util.Transacional;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class TarefaRepository implements Serializable {
    @Serial
    private static long serialVersionUID = 1L;


    @Inject
    private EntityManager manager;

    public TarefaRepository() {}


    public TarefaRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Tarefa porId(long id) {
        return manager.find(Tarefa.class, id);
    }

    public List<Tarefa> pesquisar(String termo){
        String jpql = "FROM Tarefa t WHERE t.titulo LIKE :termo OR t.descricao LIKE :termo";
        TypedQuery<Tarefa> query = manager.createQuery(jpql, Tarefa.class);
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
