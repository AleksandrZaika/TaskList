package main.dto;

import main.dto.TaskDTO;
import main.models.Task;
import org.springframework.stereotype.Service;

@Service
public class ConverterDto {

    public TaskDTO taskToDTO(Task task) {
        TaskDTO newTaskDTO = new TaskDTO();
        newTaskDTO.setId(task.getId());
        newTaskDTO.setTime(task.getTime());
        newTaskDTO.setDescription(task.getDescription());
        return newTaskDTO;
    }

    public Task taskToEntity(TaskDTO taskDTO) {
        Task newTask = new Task();
        newTask.setId(taskDTO.getId());
        newTask.setTime(taskDTO.getTime());
        newTask.setDescription(taskDTO.getDescription());
        return newTask;
    }
}
