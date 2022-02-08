package main.controllers;

import main.dto.TaskDTO;
import main.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    // принимаем и отдаём только ДТО

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/task")
    public TaskDTO create(@RequestBody TaskDTO task) {
        taskService.addTask(task);
        return task;
//        return taskService.addTask(task);
    }

    @GetMapping(value = "/task")
    public List<TaskDTO> readAllTasks() {
        List<TaskDTO> taskDTOList = taskService.getAllTask();
        return taskDTOList;
//        return taskService.getAllTask();
    }

    @PutMapping(value = "/task")
    public List<TaskDTO> readAll(@RequestBody List<TaskDTO> taskDto) {
        return taskService.getAll(taskDto);
    }

    @GetMapping(value = "/task/{id}")
    public Optional<TaskDTO> readTask(@PathVariable Integer id) {
        Optional<TaskDTO> taskDTO = taskService.findById(id);
        return taskDTO;
//        return taskService.findById(id);
    }

    @PutMapping(value = "/task/{id}")
    public TaskDTO updateTask(@PathVariable Integer id, @RequestBody TaskDTO taskDto) {
        taskService.editTask(taskDto);
        taskDto.setId(id);
        return taskDto;
//        taskDto.setId(id);
//        return taskService.editTask(taskDto);
    }

    @DeleteMapping(value = "/task/{id}")
    public Optional<TaskDTO> deleteTask(@PathVariable Integer id) {
        Optional<TaskDTO> taskDTO = taskService.delete(id);
        return taskDTO;
//        return taskService.delete(id);
    }
}
