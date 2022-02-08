package main.models;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;         //порядковый номер

    @Column(name = "time")
    private String time;            //назначенное время

    @Column(name = "description")
    private String description;     //описание задачи

    public Task() {
    }

    public Task(String time, String description) {
        this.time = time;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
