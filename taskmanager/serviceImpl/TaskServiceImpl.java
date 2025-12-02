package com.taskmanager.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.entity.Task;
import com.taskmanager.repo.TaskRepo;
import com.taskmanager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	 @Autowired
	 private TaskRepo taskRepository;

	@Override
	public Task createTask(Task task) {
		 return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		   return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Long taskId) {
		 taskRepository.deleteById(taskId);
		
	}

	@Override
	public Task getTaskById(Long taskId) {
		 Optional<Task> taskOpt = taskRepository.findById(taskId);
	        return taskOpt.orElse(null);
	}

	@Override
	public List<Task> getTasksByAssignedTo(Long userId) {
		 return taskRepository.findByAssignedToId(userId);
	}

	@Override
	public List<Task> getTasksByCreatedBy(Long managerId) {
		  return taskRepository.findByCreatedById(managerId);
	}

}
