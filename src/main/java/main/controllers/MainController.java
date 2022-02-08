package main.controllers;

import main.models.Task;
import main.models.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Task> taskIterable = taskRepository.findAll();
        List<Task> taskList = new LinkedList<>();
        taskIterable.forEach(taskList::add);

        model.addAttribute("tasks", taskList);
        model.addAttribute("tasksCount", taskList.size());
        return "index";
    }
}
