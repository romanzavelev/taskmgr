package com.expert1c.taskmgr;


import com.expert1c.taskmgr.model.Task;
import com.expert1c.taskmgr.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("name", name);
        model.addAttribute("tasks", tasks);
        return "main";
    }

    @GetMapping("/listTasks")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("name", name);
        model.addAttribute("tasks", tasks);
        return "listTasks";
    }

    @GetMapping("/listTasks/task-add")
    public String taskAdd(Model model) {
        return "task-add";
    }

    @PostMapping("/task-add")
    public String taskPostAdd(@RequestParam String content, @RequestParam String author, @RequestParam String topic, Model model) {
        Task newTask = new Task(content,author,topic);
        taskRepository.save(newTask);
        return "redirect:/listTasks";
    }

}

