package main.dto;

public class TaskDTO {

    private Integer id;

    private String time;

    private String description;

    public TaskDTO() {
    }

    public TaskDTO(String time, String description) {
        this.time = time;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
