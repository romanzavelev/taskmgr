package com.expert1c.taskmgr.repository;

import com.expert1c.taskmgr.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer>{

}
