package com.expert1c.taskmgr;


import com.expert1c.taskmgr.model.Task;
import com.expert1c.taskmgr.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/listTasks")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("name", name);
        model.addAttribute("tasks", tasks);
        return "listTasks";
    }

    @GetMapping("/")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("name", name);
        model.addAttribute("tasks", tasks);
        return "main";
    }

     @GetMapping("listTasks/task-add")
    public String taskAdd(Model model) {
        return "task-add";
    }

    @PostMapping("listTasks/task-add")
    public String taskPostAdd(@RequestParam String content, @RequestParam String author, Model model) {
        return "";
    }

   /* @GetMapping("/main")
    public String showPage(Model model, @RequestParam(defaultValue =  "0") {

        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("name", name);
        model.addAttribute("tasks", tasks);
        return "main";
    }*/

}

