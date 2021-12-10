package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.TaskRepository;

@Service
public class TaskService {

	private TaskRepository tr;
	
	@Autowired
	public TaskService(TaskRepository tr) {
		this.tr = tr;
	}
}
