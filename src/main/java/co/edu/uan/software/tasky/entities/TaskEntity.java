package co.edu.uan.software.tasky.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TASK")
public class TaskEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "uid", nullable = false)
    private UUID id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "user_id")
    private String user_id;
    @Column(name = "task_list_id")
    private String task_list_id;

    /* @ManyToOne
    @JoinColumn(name = "tag_id", insertable = false, updatable = false)
    private TagEntity tag; */

    public TaskEntity() {
    }

    public String getTaskListId() {
        return task_list_id;
    }

    public void setTaskListId(String task_list_id) {
        this.task_list_id = task_list_id;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public TaskEntity(String descripValue, String userIdValue) {
        this.setDescripcion(descripValue);
        this.setUserId(userIdValue);
    }

    @Override
    public String toString() {
        return "Task: { id: " + id + ", descripción: " + descripcion + " }";
    }

    public @Id @GeneratedValue UUID getId() {
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

}
