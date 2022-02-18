package com.expert1c.taskmgr;


import com.expert1c.taskmgr.model.Task;
import com.expert1c.taskmgr.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("name", name);
        model.addAttribute("tasks", tasks);
        return "main";
    }

}

