package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.revature.models.Task;

@RepositoryRestResource(path = "tasks")
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
