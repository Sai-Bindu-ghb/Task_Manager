package com.taskmanager.service;

import java.util.List;

import com.taskmanager.entity.Task;

public interface TaskService {
	
	Task createTask(Task task);

    Task updateTask(Long id, Task updatedTask);

    String deleteTask(Long id);

    List<Task> getAllTasks();

    List<Task> getTasksAssignedToUser(Long userId);

    List<Task> getTasksCreatedByManager(Long managerId);

    Task updateStatus(Long id, String status);
}
