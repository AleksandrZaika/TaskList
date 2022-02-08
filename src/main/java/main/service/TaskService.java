package main.service;

import main.dto.TaskDTO;
import main.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    //создание дела
    TaskDTO addTask(TaskDTO taskDTO);

    // получение списка
    List<TaskDTO> getAllTask();

    // обновление списка
    List<TaskDTO> getAll(List<TaskDTO> taskDTO);

    //получение дела по его ID
    Optional<TaskDTO> findById(Integer id);

    // обновление дела с заданным ID,
    TaskDTO editTask(TaskDTO taskDTO);

    //удаление дела с заданным ID
    Optional<TaskDTO> delete(Integer id);

}
