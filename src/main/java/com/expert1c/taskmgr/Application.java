package com.expert1c.taskmgr;

import com.expert1c.taskmgr.model.Task;
import com.expert1c.taskmgr.repository.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*@Bean
    public CommandLineRunner demo(TaskRepository repository) {
        return (args) -> {*/
            // save a few customers
         /*   repository.save(new Task("Помогите", "Bauer"));
            repository.save(new Task("Не работает", "Brian"));
            repository.save(new Task("Все пропало. Срочно", "Bauer"));
            repository.save(new Task("Нет прав. что делать. Как быть куда обратится", "Palmer"));
            repository.save(new Task("Обновите программу. Ничего не работает", "Dessler"));

           for (Task customer : repository.findAll()) {
                System.out.println(customer.toString());
                log.info(customer.toString());
           */

            // fetch an individual customer by ID
          // Task task = repository.findById();
            //log.info("Customer found with findById(1L):");
          // log.info("--------------------------------");
        //log.info(task.toString());
        //log.info("");

            // fetch customers by last name
        /*   log.info("Customer found with findByLastName('Bauer'):");
           log.info("--------------------------------------------");*/
           //repository.findByLastName("Bauer").forEach(bauer -> {
            //    log.info(bauer.toString());
          // });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
          //  log.info("");
      //  };
   // }
}
