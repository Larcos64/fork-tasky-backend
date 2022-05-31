package co.edu.uan.software.tasky.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Tag Entity, for task storage.
 */
@Entity(name = "tags")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid", nullable = false)
    private UUID uid;
    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "color")
    public String color;

    @OneToMany(mappedBy = "tag") // this means usuario is a variable in the Task class
    @JsonIgnore // this is important to avoid an infinite recursion in the relation
    private List<TaskEntity> tasks;

    public TagEntity() {
    }

    public TagEntity(String name, String color) {
        this.name = name;
        this.color = color;
        this.tasks = new ArrayList<>();
    }

    /**
     * @return return the uid
     */
    public UUID getUid() {
        return this.uid;
    }

    /**
     * @param uid to set
     */
    public void setUid(UUID uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Tag: { name: " + name + ", color: " + color + " }";
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return String return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @param name the color to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return List<TaskEntity> return the tasks
     */
    public List<TaskEntity> getTasks() {
        return tasks;
    }

    /**
     * @param tasks the tasks to set
     */
    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    /**
     * @param task the tasks to add
     */
    public void addTask(TaskEntity task) {
        this.tasks.add(task);
    }
}
