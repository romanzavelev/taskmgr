package com.expert1c.taskmgr;


import com.expert1c.taskmgr.model.Task;
import com.expert1c.taskmgr.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

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
    public String greeting(@RequestParam(defaultValue = "0") int page, Model model) {
        PageRequest pageable = PageRequest.of(page,4);
        Iterable<Task> tasks = taskRepository.findAll(pageable);
        model.addAttribute("tasks", tasks);
        model.addAttribute("CurrentPage", page);
        return "listTasks";
    }

    @GetMapping("/listTasks/task-add")
    public String taskAdd(Model model) {
        System.out.println("task-add");
        return "task-add";
    }

    @PostMapping("/listTasks/task-add")
    public String taskPostAdd(@RequestParam String content, @RequestParam String author, @RequestParam String topic, Model model) {
        System.out.println("PostMapping");
        Task newTask = new Task(content,author,topic);
        taskRepository.save(newTask);
        return "redirect:/listTasks";
    }

    @PostMapping("/listTasks/save")
    public String save(Task t) {
        taskRepository.save(t);
        return "redirect:/listTasks";
    }

    @GetMapping("/listTasks/delete")
    public String deleteTask(Task task) {
        taskRepository.delete(task);
        return "redirect:/listTasks";
    }

    @GetMapping("/listTasks/findOne")
    @ResponseBody
    public Optional<Task> findOne(int id) {
        return taskRepository.findById(id);
    }

}


