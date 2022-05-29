package co.edu.uan.software.tasky.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "tasks")
public class TaskEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "uid", nullable = false)
    private UUID id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "task_list_id")
    private String task_list_id;
    
    @ManyToOne
    private Usuario usuario;

    public TaskEntity() {
    }

    public String getTaskListId() {
        return task_list_id;
    }

    public void setTaskListId(String task_list_id) {
        this.task_list_id = task_list_id;
    }

    public TaskEntity(String descripValue, Usuario userValue) {
        this.setDescripcion(descripValue);
        this.setUsuario(userValue);
    }

    @Override
    public String toString() {
        return "Task: { id: " + id + ", descripción: " + descripcion + " }";
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return Usuario return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
