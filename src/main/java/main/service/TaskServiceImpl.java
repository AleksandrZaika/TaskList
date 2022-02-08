package main.service;

import main.dto.ConverterDto;
import main.dto.TaskDTO;
import main.models.Task;
import main.models.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskServiceImpl implements TaskService {

    // Производим операции над ДТО
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ConverterDto converterDto;

    @Override
    @Transactional
    public TaskDTO addTask(TaskDTO taskDTO) {
        Task task = converterDto.taskToEntity(taskDTO);
        taskRepository.save(task);
        taskDTO.setId(task.getId());
        return taskDTO;
    }

    @Override
    public List<TaskDTO> getAllTask() {
        Iterable<Task> iterable = taskRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(converterDto::taskToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> getAll(List<TaskDTO> taskDTO) {

        List<Task> tasks = new ArrayList<>();
        taskDTO.forEach(tasksDTO -> { tasks.add(converterDto.taskToEntity(tasksDTO)); });

        List<TaskDTO> newTaskDTO = new ArrayList<>();
        taskRepository.saveAll(tasks).forEach(task -> { newTaskDTO.add(converterDto.taskToDTO(task)); });

        return newTaskDTO;
    }

    @Override
    public Optional<TaskDTO> findById(Integer id) {
        return Optional
                .ofNullable(converterDto
                        .taskToDTO(Objects
                                .requireNonNull(taskRepository.findById(id)
                                        .orElse(null))));
    }

    @Override
    @Transactional
    public TaskDTO editTask(TaskDTO taskDTO) {
        Task task = converterDto.taskToEntity(taskDTO);
        taskRepository.save(task);
        return taskDTO;
    }

    @Override
    @Transactional
    public Optional<TaskDTO> delete(Integer id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            return Optional.empty();
        }
        taskRepository.deleteById(id);
        return Optional.of(converterDto.taskToDTO(taskOptional.get()));
    }
}
