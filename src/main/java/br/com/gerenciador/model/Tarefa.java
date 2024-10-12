package br.com.gerenciador.model;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


@Table(name = "tarefas")
@Entity
public class Tarefa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 80)
    private String titulo;

    @Column(nullable = false, length = 120)
    private String descricao;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 3)
    Responsavel responsavel;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Prioridade prioridade;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date deadline;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tarefa tarefa = (Tarefa) o;
        return id == tarefa.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                '}';
    }
}