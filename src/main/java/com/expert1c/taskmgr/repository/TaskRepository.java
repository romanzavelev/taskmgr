package com.expert1c.taskmgr.repository;

import com.expert1c.taskmgr.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
